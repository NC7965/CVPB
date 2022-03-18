package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.service.CandidatoService;
import com.altia.cvprocessingbackend.service.ReportService;

import java.io.*;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * La clase CandidatoController
 */
@RestController
@RequestMapping("/candidatos")
@Slf4j
@CrossOrigin("*")
public class CandidatoController {

    public int STATUS_CODE_OK = 200;
    /**
     * El servicio de Candidato
     */
    @Autowired
    private CandidatoService candidatoService;

    /**
     * El servicio de Reportes
     */
    @Autowired
    private ReportService reportService;

    /**
     * Busca por id un candidato y lo devuelve
     * @param id
     * @return El CandidatoVO(Mono)
     */
    @GetMapping("/{id}")
    public Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return candidatoService.findById(id);
    }

    /**
     * Crea un CV y llama a dedalo
     * @param candidatoVO
     * @return "OK" si en el header <Authorization> se provee un token válido de dédalo, Error 401 en caso contrario.
     */
    @PostMapping("/candidatura")
    public String SaveDedalo(@RequestBody CandidatoVO candidatoVO) throws JRException, FileNotFoundException {
        log.info("request body recibido en hebra {}",Thread.currentThread().getName());

        candidatoService.saveCandidato(candidatoVO);
        Mono<Resource> report = reportService.exportReport(candidatoVO.getEmail(),candidatoVO.getSitioWeb());
        return "OK";
    }

    /**
     * Crea un CV y lo almacena
     * @param candidatoVO
     * @return Almacena el candidato en la base de datos.
     */
    @PostMapping("/")
    public String  crearCV(@RequestBody CandidatoVO candidatoVO) {
        log.info("request body recibido en hebra {}",Thread.currentThread().getName());
        candidatoService.saveCandidato(candidatoVO);
        return "Almacenado correcto";
    }


    /**
     * Busca y devuelve todos los candidatos
     * @return El/los CandidatoVO(Flux)
     */
    @GetMapping("/all")
    public Flux<CandidatoVO> findAll(){
        return candidatoService.findAll();
    }

    /**
     *
     * @param email
     * @param platform
     * @param response
     * @return fichero CV
     * @throws JRException
     * @throws FileNotFoundException
     * @throws JRException
     */
    @GetMapping(value = "/report" ,  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public Mono<Resource> exportReport (@RequestParam String email, @RequestParam String platform, ServerHttpResponse response) throws JRException, FileNotFoundException, JRException {

        response.getHeaders().add("Content-Disposition",String.format("attachment; filename=%s.pdf",email));
        log.info("request report recibido en hebra {}",Thread.currentThread().getName());
        return reportService.exportReport( email,platform);
    }


}

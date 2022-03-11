package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.runner.Runner;
import com.altia.cvprocessingbackend.service.CandidatoService;
import com.altia.cvprocessingbackend.service.ReportService;
import java.io.ByteArrayInputStream;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/candidatos")
@Slf4j
@CrossOrigin("*")
public class CandidatoController {


    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private ReportService reportService;


    @GetMapping("/{id}")
    public Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return candidatoService.findById(id);
    }

    @PostMapping("/")
    public String crearCV(@RequestBody CandidatoVO candidatoVO) {
        log.info("request body recibido en hebra {}",Thread.currentThread().getName());

        candidatoService.saveCandidato(candidatoVO);
        return "Almacenado correcto";
    }

    @GetMapping("")
    public Flux<CandidatoVO> findAll(){
        return candidatoService.findAll();
    }


    @GetMapping(value = "/report" ,  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public Mono<Resource> exportReport (@RequestParam String email, @RequestParam String platform, ServerHttpResponse response) throws JRException, FileNotFoundException, JRException {

        response.getHeaders().add("Content-Disposition",String.format("attachment; filename=%s.pdf",email));
        log.info("request report recibido en hebra {}",Thread.currentThread().getName());
        return reportService.exportReport( email,platform);
    }


}

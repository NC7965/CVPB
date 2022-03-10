package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.service.CandidatoService;
import com.altia.cvprocessingbackend.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
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
        log.info("request body recibido {}",candidatoVO);
        candidatoService.saveCandidato(candidatoVO);
        return "Almacenado correcto";
    }

    @GetMapping("")
    public Flux<CandidatoVO> findAll(){
        return candidatoService.findAll();
    }


    @GetMapping("/report")
    @ResponseBody
    public String exportReport (@RequestParam String email, @RequestParam String platform) throws JRException, FileNotFoundException, JRException {
        return reportService.exportReport( email,platform); //
    }


}

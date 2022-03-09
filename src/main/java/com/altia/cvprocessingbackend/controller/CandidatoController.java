package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.service.CandidatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/candidatos")
@Slf4j
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;
    @GetMapping("/{id}")
    public Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return candidatoService.findById(id);
    }

    @PostMapping("/")
    public String crearCV(@RequestBody CandidatoVO candidatoVO) {
        log.info("request body recibido {}",candidatoVO);
        candidatoService.saveCandidato(candidatoVO);
        return "CV creado correctamente";
    }

    @GetMapping("")
    public Flux<CandidatoVO> findAll(){
        return candidatoService.findAll();
    }
}

package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/candidatos")
@Slf4j
public class CandidatoController {

    @GetMapping("/{id}")
    private Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return null;
    }

    @PostMapping("/")
    private String crearCV(@RequestBody CandidatoVO candidatoVO) {
        log.info("request body recibido {}",candidatoVO);
        return "CV creado correctamente";
    }
}

package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @GetMapping("/{id}")
    private Mono<CandidatoVO> getCandidato(@PathVariable("id") String id) {
        return null;
    }

    @PostMapping("/")
    private String crearCV(@RequestBody CandidatoVO candidatoVO) {
        return "CV creado correctamente";
    }
}

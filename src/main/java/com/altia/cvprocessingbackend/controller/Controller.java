package com.altia.cvprocessingbackend.controller;

import com.altia.cvprocessingbackend.vo.CandidatoVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    private String hola() {
        return "hola";
    }

    @PostMapping("cv")
    private String crearCV(@RequestBody CandidatoVO candidatoVO) {
        return candidatoVO.toString();
    }
}

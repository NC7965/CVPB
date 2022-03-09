package com.altia.cvprocessingbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    private String hola() {
        return "hola";
    }

    @PostMapping("cv")
    private String crearCV() {
        return "CV creado correctamente";
    }
}

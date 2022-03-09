package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {

    private String cargo;
    private String empresa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String salario;
    private String nivel;
}

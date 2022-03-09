package com.altia.cvprocessingbackend.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExperienciaVO {

    private String cargo;
    private String empresa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String salario;
    private String nivel;
}

package com.altia.cvprocessingbackend.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaVO {

    private String cargo;
    private String empresa;
    private String fechasYDuracion;
    private String salario;
    private String nivel;
    private String descripcion;
    private List<String> habilidades;
}

package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {

    private String cargo;
    private String empresa;
    private String fechasYDuracion;
    private String salario;
    private String nivel;
    private String descripcion;
    private List<String> habilidades;
}

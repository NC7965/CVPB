package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Estudio {

    private String titulo;
    private String especialidad;
    private String institucion;

}

package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Estudio
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudio {

    /** Tipo de titulo del Estudio*/
    private String titulo;

    /** Especialidad del Estudio */
    private String especialidad;

    /** Institucion en la que se ha estudiado */
    private String institucion;

}

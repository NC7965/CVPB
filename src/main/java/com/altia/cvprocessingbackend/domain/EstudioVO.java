package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * La clase EstudioVO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudioVO {

    /** Tipo de titulo del EstudioVO*/
    private String titulo;

    /** Especialidad del EstudioVO*/
    private String especialidad;

    /** Institucion en la que se ha estudiado */
    private String institucion;

}

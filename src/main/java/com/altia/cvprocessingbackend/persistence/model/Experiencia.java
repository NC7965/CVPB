package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import lombok.NoArgsConstructor;

/**
 * La clase Experiencia
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {

    /** Cargo desempeñado en la experiencia laboral */
    private String cargo;

    /** Empresa en la que se ha desempeñado la experiencia laboral */
    private String empresa;

    /** Fechas de inicio, fin y duracion de la experiencia laboral */
    private String fechasYDuracion;

    /** Salario obtenido en la experiencia laborar */
    private String salario;

    /** Nivel de la experiencia laboral */
    private String nivel;

    /** Descripcion de la experiencia laboral */
    private String descripcion;

    /** Habilidades utilizadas en la experiencia laboral */
    private List<String> habilidades;
}

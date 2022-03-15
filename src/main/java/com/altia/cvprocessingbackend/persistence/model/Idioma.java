package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Idioma
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idioma {

    /** Idioma */
    private String idioma;

    /** nivel del Candidato en el Idioma correspondiente */
    private String nivel;

    /** Comentario sobre el idioma */
    private String comentario;

}

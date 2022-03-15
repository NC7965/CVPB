package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase IdiomaVO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdiomaVO {

    /** Idioma */
    private String idioma;

    /** nivel del Candidato en el Idioma correspondiente */
    private String nivel;

    /** Comentario sobre el idioma */
    private String comentario;

}

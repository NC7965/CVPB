package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdiomaVO {

    private String idioma;
    private String nivel;
    private String comentario;

}

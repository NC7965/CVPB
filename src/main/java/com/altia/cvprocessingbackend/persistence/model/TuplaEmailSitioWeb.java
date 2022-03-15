package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase TuplaEmailSitioWeb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuplaEmailSitioWeb {

        /** Email */
        private String email;

        /** Sitio Web */
        private String sitioWeb;
}

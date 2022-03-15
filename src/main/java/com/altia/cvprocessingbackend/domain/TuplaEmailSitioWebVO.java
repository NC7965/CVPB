package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * La clase TuplaEmailSitioWebVO
 */
@Data
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
public class TuplaEmailSitioWebVO {

  /** Email */
  private String email;

  /** Sitio Web */
  private String sitioWeb;
}

package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@AllArgsConstructor
public class TuplaEmailSitioWebVO {
  private String email;
  private String sitioWeb;
}

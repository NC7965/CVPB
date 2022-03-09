package com.altia.cvprocessingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
public class TuplaEmailSitioWebVO {
  private String email;
  private String sitioWeb;
}

package com.altia.cvprocessingbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidatoVO {
  private String id;
  private String email;
  private String sitioWeb;
  private String nombre;
  private String telefono;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate fechaNacimiento;
  private String ciudadResidencia;
  private String carnetConducir;
  private String vehiculoPropio;
  private String nacionalidad;
  private String permisoTrabajo;
  private Boolean autonomo;
  private String situacionLaboral;
  private String puestroPreferido;
  private String categoriaPreferida;
  private String disponibilidadViajar;
  private String disponibilidadCambiarResidencia;
  private String cvEnTexto;
  private List<String> conocimientos;
  private List<EstudioVO> estudios;
  private List<ExperienciaVO> experienciaLaboral;
  private List<IdiomaVO> idiomas;
  private LocalDate fechaActualizacion;

}

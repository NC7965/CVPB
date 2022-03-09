package com.altia.cvprocessingbackend.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoVO {
  private String id;
  private TuplaEmailSitioWebVO clavePrimaria;
  private String nombre;
  private String telefono;
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

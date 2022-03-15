package com.altia.cvprocessingbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase CandidatoVO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidatoVO {
  /** El id del CandidatoVO */
  private String id;

  /** El email del CandidatoVO */
  private String email;

  /** El sitioWeb del que se ha obtenido el perfil del CandidatoVO */
  private String sitioWeb;

  /** El nombre del CandidatoVO */
  private String nombre;

  /** El telefono del CandidatoVO */
  private String telefono;

  /** La fecha de nacimiento del CandidatoVO */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate fechaNacimiento;

  /** La ciudad de residencia del CandidatoVO */
  private String ciudadResidencia;

  /** El tipo de carnet de conducir del CandidatoVO */
  private String carnetConducir;

  /** Si tiene vehiculo propio el CandidatoVO */
  private String vehiculoPropio;

  /** Nacionalidad del CandidatoVO */
  private String nacionalidad;

  /** Lugares donde tiene permiso de trabajo el CandidatoVO */
  private String permisoTrabajo;

  /** Si el CandidatoVO es autonomo o no */
  private Boolean autonomo;

  /** La situacion laboral del CandidatoVO */
  private String situacionLaboral;

  /** El puesto preferido del CandidatoVO */
  private String puestroPreferido;

  /** La categoria preferida del CandidatoVO */
  private String categoriaPreferida;

  /** La disponibilidad para viajar del CandidatoVO */
  private String disponibilidadViajar;

  /** La disponibilidad para cambiar de residencia del CandidatoVO */
  private String disponibilidadCambiarResidencia;

  /** El cv en texto del CandidatoVO */
  private String cvEnTexto;

  /** Lista con los conocimientos del CandidatoVO */
  private List<String> conocimientos;

  /** Lista de Estudios del CandidatoVO */
  private List<EstudioVO> estudios;

  /** Lista de experiencias laborales del CandidatoVO */
  private List<ExperienciaVO> experienciaLaboral;

  /** Lista de idiomas del CandidatoVO */
  private List<IdiomaVO> idiomas;

  /** Fecha de actualizacion del CV del CandidatoVO */
  private LocalDate fechaActualizacion;

}

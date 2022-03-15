package com.altia.cvprocessingbackend.persistence.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * La clase Candidato
 */
@Document(collection = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

    /** El id del Candidato */
    @Id
    @Field(value = "_id")
    private ObjectId id;

    /** El email del Candidato */
    private String email;

    /** El sitioWeb del que se ha obtenido el perfil del Candidato */
    private String sitioWeb;

    /** El nombre del Candidato */
    private String nombre;

    /** El telefono del Candidato */
    private String telefono;

    /** El telefono del Candidato */
    private LocalDate fechaNacimiento;

    /** La ciudad de residencia del Candidato */
    private String ciudadResidencia;

    /** El tipo de carnet de conducir del Candidato */
    private String carnetConducir;

    /** Si tiene vehiculo propio el Candidato */
    private String vehiculoPropio;

    /** Nacionalidad del Candidato */
    private String nacionalidad;

    /** Lugares donde tiene permiso de trabajo el Candidato */
    private String permisoTrabajo;

    /** Si el candidato es autonomo o no */
    private Boolean autonomo;

    /** La situacion laboral del Candidato */
    private String situacionLaboral;

    /** El puesto preferido del Candidato */
    private String puestroPreferido;

    /** La categoria preferida del Candidato */
    private String categoriaPreferida;

    /** La disponibilidad para viajar del Candidato */
    private String disponibilidadViajar;

    /** La disponibilidad para cambiar de residencia del Candidato */
    private String disponibilidadCambiarResidencia;

    /** El cv en texto del Candidato */
    private String cvEnTexto;

    /** Lista con los conocimientos del Candidato */
    private List<String> conocimientos;

    /** Lista de Estudios del Candidato */
    private List<Estudio> estudios;

    /** Lista de experiencias laborales del Candidato */
    private List<Experiencia> experienciaLaboral;

    /** Lista de idiomas del Candidato */
    private List<Idioma> idiomas;

    /** Fecha de actualizacion del CV del candidato */
    private LocalDate fechaActualizacion;
}

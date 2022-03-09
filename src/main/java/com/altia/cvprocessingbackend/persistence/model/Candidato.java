package com.altia.cvprocessingbackend.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "candidates")
@Data
@AllArgsConstructor
public class Candidato {

    @Id
    private TuplaEmailSitioWeb clavePrimaria;
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
    private List<Estudio> estudios;
    private List<Experiencia> experienciaLaboral;
    private List<Idioma> idiomas;
    private LocalDate fechaActualizacion;

    @Data
    @ToString(includeFieldNames = true)
    @AllArgsConstructor
    public static class TuplaEmailSitioWeb {
        private String email;
        private String sitioWeb;
    }
}

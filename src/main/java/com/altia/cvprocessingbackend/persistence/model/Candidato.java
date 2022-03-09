package com.altia.cvprocessingbackend.persistence.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

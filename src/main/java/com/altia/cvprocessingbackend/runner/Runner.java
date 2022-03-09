package com.altia.cvprocessingbackend.runner;

import com.altia.cvprocessingbackend.persistence.model.Candidato;
import com.altia.cvprocessingbackend.persistence.model.TuplaEmailSitioWeb;
import com.altia.cvprocessingbackend.persistence.model.Estudio;
import com.altia.cvprocessingbackend.persistence.model.Experiencia;
import com.altia.cvprocessingbackend.persistence.model.Idioma;
import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Creando candidatos");

        /*var candidatos = List.of(new Candidato(new TuplaEmailSitioWeb("nicolascuello@hotmail.com", "InfoJobs"),
                "Nicolas Cuello", "663487529", LocalDate.of(1998, 04, 20), "Elche", "B",
                "Si", "Argentina", "Unión Europea, Argentina", false, "Empleado", "Software Developer",
                "Software", "Mala", "Mala", "Hola soy nicolas cuello yy aqui estoy", List.of("Node JS", "Java"),
                List.of(new Estudio("Grado", "Ingeniería informática", "Universidad de Alicante"),
                        new Estudio("Bachillerato", "Ciencias", "IES Pedro Ibarra Ruíz")),
                List.of(new Experiencia("Software Developer", "Altia", LocalDate.of(2021, 12, 1),
                        null, "1500-1800 € brutos/mes", "Becario/a - Prácticas"), new Experiencia("Software Developer", "Autonomo", LocalDate.of(2021, 9, 1),
                        LocalDate.of(2021, 12, 1), "1600 € Brutos/mes", "Becario")),
                List.of(new Idioma("Inglés", "Alto", "He estudiado 3 años de inglés"), new Idioma("Castellano", "Nativo", "Nacido en España")), LocalDate.now()));

        Mono<Void> one = candidatoRepository.deleteAll();

        Flux<Candidato> two = candidatoRepository.saveAll(candidatos);
        Flux<Candidato> three = candidatoRepository.findAll();
        three.subscribe(candidato -> logger.info("{}", candidato));
        logger.info(("Finished"));

        Mono<Void> all = Mono.when(one, two, three);
        all.block();*/
    }
}

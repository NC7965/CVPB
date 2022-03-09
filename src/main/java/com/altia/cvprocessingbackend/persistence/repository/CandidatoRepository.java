package com.altia.cvprocessingbackend.persistence.repository;

import com.altia.cvprocessingbackend.persistence.model.Candidato;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends ReactiveCrudRepository<Candidato, Candidato.TuplaEmailSitioWeb> {
}

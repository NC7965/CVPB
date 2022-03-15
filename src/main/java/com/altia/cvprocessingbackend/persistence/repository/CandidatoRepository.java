package com.altia.cvprocessingbackend.persistence.repository;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * La interfaz CandidatoRepository
 */
@Repository
public interface CandidatoRepository extends ReactiveCrudRepository<Candidato, ObjectId> {

    /**
     * Find by Email
     * @param email
     * @param platform
     * @return el Candidato
     */
    @Query("{ $and:[{'email' : ?0}, {'sitioWeb': ?1} ]}")
    Mono<Candidato> findByEmail(String email, String platform);


}

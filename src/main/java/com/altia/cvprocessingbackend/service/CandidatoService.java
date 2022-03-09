package com.altia.cvprocessingbackend.service;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CandidatoService {


  void saveCandidato(CandidatoVO candidatoVO);

  Mono<CandidatoVO> findById(String id);

  Flux<CandidatoVO> findAll();
}

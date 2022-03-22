package com.altia.cvprocessingbackend.service;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * La interfaz CandidatoService
 */
public interface CandidatoService {

  /**
   * Guarda un Candidato
   * @param candidatoVO
   */
  void saveCandidato(CandidatoVO candidatoVO);

  /**
   * Busca Candidato por Id
   * @param id
   * @return el CandidatoVO(Mono)
   */
  Mono<CandidatoVO> findById(String id);

  /**
   * Obtiene todos los Candidatos
   * @return Los Candidatos(Flux)
   */
  Flux<CandidatoVO> findAll();

  /**
   * Envia el reporte a Dedalo y obtiene un token
   * @param report
   * @return token correspondiente al fichero enviado
   */
  Mono<String> uploadReport(Mono<Resource> report, String authToken);
}

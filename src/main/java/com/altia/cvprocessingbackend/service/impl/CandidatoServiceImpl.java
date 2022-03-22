package com.altia.cvprocessingbackend.service.impl;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.mapper.CandidatoMapper;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import com.altia.cvprocessingbackend.runner.Runner;
import com.altia.cvprocessingbackend.service.CandidatoService;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * La clase CandidatoServiceImpl
 */
@Service
public class CandidatoServiceImpl implements CandidatoService {
  private static final Logger logger = LoggerFactory.getLogger(Runner.class);

  /**
   * El Mapper de Candidato
   */
  @Autowired
  private CandidatoMapper candidatoMapper;

  /**
   * El repositorio de Candidato
   */
  @Autowired
  private CandidatoRepository candidatoRepository;

  /**
   * Guarda el Candidato
   * @param candidatoVO
   */
  @Override
  public void saveCandidato(CandidatoVO candidatoVO) {

    candidatoRepository.findByEmail(candidatoVO.getEmail(), candidatoVO.getSitioWeb())
            .subscribeOn(Schedulers.boundedElastic()).switchIfEmpty(Mono.just(candidatoMapper.voToEntity(candidatoVO))).
            subscribe(candidato -> {
              candidatoVO.setId(Optional.ofNullable(candidato.getId()).map(id -> id.toString()).orElse(null));

              candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO))
                      .subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
            });
  }

  /**
   * Busca Candidato por Id
   * @param id
   * @return el CandidatoVO(Mono)
   */
  @Override
  public Mono<CandidatoVO> findById(String id) {
    return candidatoRepository.findById(new ObjectId(id)).map(this.candidatoMapper::entityToVo);
  }

  /**
   * Obtiene todos los Candidatos
   * @return Los Candidatos(Flux)
   */
  @Override
  public Flux<CandidatoVO> findAll() {
    return candidatoRepository.findAll().map(this.candidatoMapper::entityToVo);
  }

  /**
   * Envia el reporte a Dedalo y obtiene un token
   * @param report
   * @return token correspondiente al fichero enviado
   */
  @Override
  public Mono<String> uploadReport(Mono<Resource> report, String authToken) {
    WebClient client = WebClient.builder()
            .baseUrl("https://pre2-dedalo.altia.es/dedalonext")
            .build();
    Mono<String> response = client.post()
            .uri(uriBuilder -> uriBuilder.pathSegment("uploads.json").queryParam("filename", "fichero.docx").build())
            //.uri("/uploads.json?filename=file.docx")
            .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
            .header("X-Redmine-API-Key", authToken)
            .retrieve()
            .onStatus(HttpStatus::is3xxRedirection, clientResponse -> {
              logger.error("Error endpoint with status code {}",  clientResponse.statusCode());
              throw new BadCredentialsException("User token not valid "+ authToken);
            })
            .onStatus(HttpStatus::isError, clientResponse -> {
              logger.error("Error endpoint with status code {}",  clientResponse.statusCode());
              throw new AuthenticationServiceException("Unsuported Exception "+ authToken);
            }).bodyToMono(String.class);
    return response.map(s -> {
      JSONObject json = new JSONObject(s);
      return json.getJSONObject("upload").getString("token");
    });
  }

}

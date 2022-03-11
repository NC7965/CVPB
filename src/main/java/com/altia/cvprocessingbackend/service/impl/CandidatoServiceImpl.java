package com.altia.cvprocessingbackend.service.impl;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.mapper.CandidatoMapper;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import com.altia.cvprocessingbackend.runner.Runner;
import com.altia.cvprocessingbackend.service.CandidatoService;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CandidatoServiceImpl implements CandidatoService {
  private static final Logger logger = LoggerFactory.getLogger(Runner.class);

  @Autowired
  private CandidatoMapper candidatoMapper;

  @Autowired
  private CandidatoRepository candidatoRepository;

  @Override
  public void saveCandidato(CandidatoVO candidatoVO) {

    candidatoRepository.findByEmail(candidatoVO.getEmail(), candidatoVO.getSitioWeb())
            .subscribeOn(Schedulers.boundedElastic()).switchIfEmpty(Mono.just(candidatoMapper.voToEntity(candidatoVO))).
            subscribe(candidato -> {
              candidatoVO.setId(Optional.ofNullable(candidato.getId()).map(id -> id.toString()).orElse(null));

              candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO))
                      .subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
            });

    //boolean exists = existsCandidato(candidatoVO).get();

    /*if(!exists){
      candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
    }*/
    //candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();


    /*if(!existsCandidato(candidatoVO).get()){
      logger.info("Si existeee -> en saveCandidato!");
      candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
    }
    else if (existsCandidato(candidatoVO).get()){
      logger.info("No existeee -> en saveCandidato!");
      candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();

    }*/
    /*
    existsCandidato(candidatoVO).map( value -> {
        if(value){
          logger.info("Si que existe -> en saveCandidato!");

        }
        else{
          logger.info("No existe -> en saveCandidato!");
          candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
        }
        return "";
    }).subscribeOn(Schedulers.boundedElastic()).subscribe();*/
  }

  @Override
  public Mono<CandidatoVO> findById(String id) {
    return candidatoRepository.findById(new ObjectId(id)).map(this.candidatoMapper::entityToVo);
  }

  @Override
  public Flux<CandidatoVO> findAll() {
    return candidatoRepository.findAll().map(this.candidatoMapper::entityToVo);
  }

  public AtomicBoolean existsCandidato(CandidatoVO candidatoVO){ //T if no exists & F when exists
    logger.info("existeCandidato? "+ candidatoVO.getEmail() + " en el sitioweb: " + candidatoVO.getSitioWeb());

    //Candidato candidato = candidatoRepository.findByEmailCandidato(candidatoVO.getEmail(), candidatoVO.getSitioWeb());
    AtomicBoolean empty = new AtomicBoolean();
    candidatoRepository.findByEmail(candidatoVO.getEmail(), candidatoVO.getSitioWeb())
            .subscribeOn(Schedulers.boundedElastic())
            .subscribe(candidato -> {
              empty.set(candidato==null);
              if(candidato!=null){
                candidatoRepository.delete(candidato).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();
              }
              candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribeOn(Schedulers.newParallel("reporting-thread")).subscribe();

            });
    logger.info("value de empty: "+empty);

    return empty;
  }
}

package com.altia.cvprocessingbackend.service.impl;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.mapper.CandidatoMapper;
import com.altia.cvprocessingbackend.persistence.repository.CandidatoRepository;
import com.altia.cvprocessingbackend.service.CandidatoService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CandidatoServiceImpl implements CandidatoService {

  @Autowired
  private CandidatoMapper candidatoMapper;

  @Autowired
  private CandidatoRepository candidatoRepository;
  @Override
  public void saveCandidato(CandidatoVO candidatoVO) {

    candidatoRepository.save(candidatoMapper.voToEntity(candidatoVO)).subscribe();
  }

  @Override
  public Mono<CandidatoVO> findById(String id) {
    return candidatoRepository.findById(new ObjectId(id)).map(this.candidatoMapper::entityToVo);
  }

  @Override
  public Flux<CandidatoVO> findAll() {
    return candidatoRepository.findAll().map(this.candidatoMapper::entityToVo);
  }
}

package com.altia.cvprocessingbackend.mapper;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidatoMapper extends BaseMapper<Candidato, CandidatoVO>{

}

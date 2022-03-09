package com.altia.cvprocessingbackend.mapper;

import com.altia.cvprocessingbackend.persistence.model.Candidato;
import com.altia.cvprocessingbackend.vo.CandidatoVO;
import com.microservicios.utilities.mapper.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidatoMapper extends IMapper<Candidato, CandidatoVO>{

    @Override
    Candidato modelToEntity(CandidatoVO candidatoVO);

    @Override
    CandidatoVO entityToModel(Candidato candidato);
}

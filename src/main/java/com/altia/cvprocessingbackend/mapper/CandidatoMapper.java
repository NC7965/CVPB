package com.altia.cvprocessingbackend.mapper;


import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

/**
 * La interfaz CandidatoMapper
 */
@Mapper(componentModel = "spring")
public interface CandidatoMapper extends BaseMapper<Candidato, CandidatoVO>{

  /**
   * Map.
   *
   * @param value the value
   * @return the string
   */
  default String map(ObjectId value) {
    return value.toString();
  }

  /**
   * Map.
   *
   * @param value the value
   * @return the object id
   */
  default ObjectId map(String value) {
    return Optional.ofNullable(value).map(id->new ObjectId(id)).orElse(null);
  }

}

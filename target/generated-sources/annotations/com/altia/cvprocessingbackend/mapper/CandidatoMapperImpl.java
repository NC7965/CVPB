package com.altia.cvprocessingbackend.mapper;

import com.altia.cvprocessingbackend.domain.CandidatoVO;
import com.altia.cvprocessingbackend.domain.EstudioVO;
import com.altia.cvprocessingbackend.domain.ExperienciaVO;
import com.altia.cvprocessingbackend.domain.IdiomaVO;
import com.altia.cvprocessingbackend.domain.TuplaEmailSitioWebVO;
import com.altia.cvprocessingbackend.persistence.model.Candidato;
import com.altia.cvprocessingbackend.persistence.model.Estudio;
import com.altia.cvprocessingbackend.persistence.model.Experiencia;
import com.altia.cvprocessingbackend.persistence.model.Idioma;
import com.altia.cvprocessingbackend.persistence.model.TuplaEmailSitioWeb;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-09T13:09:08+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class CandidatoMapperImpl implements CandidatoMapper {

    @Override
    public CandidatoVO entityToVo(Candidato e) {
        if ( e == null ) {
            return null;
        }

        CandidatoVO candidatoVO = new CandidatoVO();

        candidatoVO.setId( map( e.getId() ) );
        candidatoVO.setClavePrimaria( tuplaEmailSitioWebToTuplaEmailSitioWebVO( e.getClavePrimaria() ) );
        candidatoVO.setNombre( e.getNombre() );
        candidatoVO.setTelefono( e.getTelefono() );
        candidatoVO.setFechaNacimiento( e.getFechaNacimiento() );
        candidatoVO.setCiudadResidencia( e.getCiudadResidencia() );
        candidatoVO.setCarnetConducir( e.getCarnetConducir() );
        candidatoVO.setVehiculoPropio( e.getVehiculoPropio() );
        candidatoVO.setNacionalidad( e.getNacionalidad() );
        candidatoVO.setPermisoTrabajo( e.getPermisoTrabajo() );
        candidatoVO.setAutonomo( e.getAutonomo() );
        candidatoVO.setSituacionLaboral( e.getSituacionLaboral() );
        candidatoVO.setPuestroPreferido( e.getPuestroPreferido() );
        candidatoVO.setCategoriaPreferida( e.getCategoriaPreferida() );
        candidatoVO.setDisponibilidadViajar( e.getDisponibilidadViajar() );
        candidatoVO.setDisponibilidadCambiarResidencia( e.getDisponibilidadCambiarResidencia() );
        candidatoVO.setCvEnTexto( e.getCvEnTexto() );
        List<String> list = e.getConocimientos();
        if ( list != null ) {
            candidatoVO.setConocimientos( new ArrayList<String>( list ) );
        }
        candidatoVO.setEstudios( estudioListToEstudioVOList( e.getEstudios() ) );
        candidatoVO.setExperienciaLaboral( experienciaListToExperienciaVOList( e.getExperienciaLaboral() ) );
        candidatoVO.setIdiomas( idiomaListToIdiomaVOList( e.getIdiomas() ) );
        candidatoVO.setFechaActualizacion( e.getFechaActualizacion() );

        return candidatoVO;
    }

    @Override
    public Candidato voToEntity(CandidatoVO v) {
        if ( v == null ) {
            return null;
        }

        Candidato candidato = new Candidato();

        candidato.setId( map( v.getId() ) );
        candidato.setClavePrimaria( tuplaEmailSitioWebVOToTuplaEmailSitioWeb( v.getClavePrimaria() ) );
        candidato.setNombre( v.getNombre() );
        candidato.setTelefono( v.getTelefono() );
        candidato.setFechaNacimiento( v.getFechaNacimiento() );
        candidato.setCiudadResidencia( v.getCiudadResidencia() );
        candidato.setCarnetConducir( v.getCarnetConducir() );
        candidato.setVehiculoPropio( v.getVehiculoPropio() );
        candidato.setNacionalidad( v.getNacionalidad() );
        candidato.setPermisoTrabajo( v.getPermisoTrabajo() );
        candidato.setAutonomo( v.getAutonomo() );
        candidato.setSituacionLaboral( v.getSituacionLaboral() );
        candidato.setPuestroPreferido( v.getPuestroPreferido() );
        candidato.setCategoriaPreferida( v.getCategoriaPreferida() );
        candidato.setDisponibilidadViajar( v.getDisponibilidadViajar() );
        candidato.setDisponibilidadCambiarResidencia( v.getDisponibilidadCambiarResidencia() );
        candidato.setCvEnTexto( v.getCvEnTexto() );
        List<String> list = v.getConocimientos();
        if ( list != null ) {
            candidato.setConocimientos( new ArrayList<String>( list ) );
        }
        candidato.setEstudios( estudioVOListToEstudioList( v.getEstudios() ) );
        candidato.setExperienciaLaboral( experienciaVOListToExperienciaList( v.getExperienciaLaboral() ) );
        candidato.setIdiomas( idiomaVOListToIdiomaList( v.getIdiomas() ) );
        candidato.setFechaActualizacion( v.getFechaActualizacion() );

        return candidato;
    }

    @Override
    public List<Candidato> vosToEntities(List<CandidatoVO> vs) {
        if ( vs == null ) {
            return null;
        }

        List<Candidato> list = new ArrayList<Candidato>( vs.size() );
        for ( CandidatoVO candidatoVO : vs ) {
            list.add( voToEntity( candidatoVO ) );
        }

        return list;
    }

    @Override
    public List<CandidatoVO> entitiesToVos(List<Candidato> es) {
        if ( es == null ) {
            return null;
        }

        List<CandidatoVO> list = new ArrayList<CandidatoVO>( es.size() );
        for ( Candidato candidato : es ) {
            list.add( entityToVo( candidato ) );
        }

        return list;
    }

    protected TuplaEmailSitioWebVO tuplaEmailSitioWebToTuplaEmailSitioWebVO(TuplaEmailSitioWeb tuplaEmailSitioWeb) {
        if ( tuplaEmailSitioWeb == null ) {
            return null;
        }

        TuplaEmailSitioWebVO tuplaEmailSitioWebVO = new TuplaEmailSitioWebVO();

        tuplaEmailSitioWebVO.setEmail( tuplaEmailSitioWeb.getEmail() );
        tuplaEmailSitioWebVO.setSitioWeb( tuplaEmailSitioWeb.getSitioWeb() );

        return tuplaEmailSitioWebVO;
    }

    protected EstudioVO estudioToEstudioVO(Estudio estudio) {
        if ( estudio == null ) {
            return null;
        }

        EstudioVO estudioVO = new EstudioVO();

        estudioVO.setTitulo( estudio.getTitulo() );
        estudioVO.setEspecialidad( estudio.getEspecialidad() );
        estudioVO.setInstitucion( estudio.getInstitucion() );

        return estudioVO;
    }

    protected List<EstudioVO> estudioListToEstudioVOList(List<Estudio> list) {
        if ( list == null ) {
            return null;
        }

        List<EstudioVO> list1 = new ArrayList<EstudioVO>( list.size() );
        for ( Estudio estudio : list ) {
            list1.add( estudioToEstudioVO( estudio ) );
        }

        return list1;
    }

    protected ExperienciaVO experienciaToExperienciaVO(Experiencia experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        ExperienciaVO experienciaVO = new ExperienciaVO();

        experienciaVO.setCargo( experiencia.getCargo() );
        experienciaVO.setEmpresa( experiencia.getEmpresa() );
        experienciaVO.setFechaInicio( experiencia.getFechaInicio() );
        experienciaVO.setFechaFin( experiencia.getFechaFin() );
        experienciaVO.setSalario( experiencia.getSalario() );
        experienciaVO.setNivel( experiencia.getNivel() );

        return experienciaVO;
    }

    protected List<ExperienciaVO> experienciaListToExperienciaVOList(List<Experiencia> list) {
        if ( list == null ) {
            return null;
        }

        List<ExperienciaVO> list1 = new ArrayList<ExperienciaVO>( list.size() );
        for ( Experiencia experiencia : list ) {
            list1.add( experienciaToExperienciaVO( experiencia ) );
        }

        return list1;
    }

    protected IdiomaVO idiomaToIdiomaVO(Idioma idioma) {
        if ( idioma == null ) {
            return null;
        }

        IdiomaVO idiomaVO = new IdiomaVO();

        idiomaVO.setIdioma( idioma.getIdioma() );
        idiomaVO.setNivel( idioma.getNivel() );
        idiomaVO.setComentario( idioma.getComentario() );

        return idiomaVO;
    }

    protected List<IdiomaVO> idiomaListToIdiomaVOList(List<Idioma> list) {
        if ( list == null ) {
            return null;
        }

        List<IdiomaVO> list1 = new ArrayList<IdiomaVO>( list.size() );
        for ( Idioma idioma : list ) {
            list1.add( idiomaToIdiomaVO( idioma ) );
        }

        return list1;
    }

    protected TuplaEmailSitioWeb tuplaEmailSitioWebVOToTuplaEmailSitioWeb(TuplaEmailSitioWebVO tuplaEmailSitioWebVO) {
        if ( tuplaEmailSitioWebVO == null ) {
            return null;
        }

        TuplaEmailSitioWeb tuplaEmailSitioWeb = new TuplaEmailSitioWeb();

        tuplaEmailSitioWeb.setEmail( tuplaEmailSitioWebVO.getEmail() );
        tuplaEmailSitioWeb.setSitioWeb( tuplaEmailSitioWebVO.getSitioWeb() );

        return tuplaEmailSitioWeb;
    }

    protected Estudio estudioVOToEstudio(EstudioVO estudioVO) {
        if ( estudioVO == null ) {
            return null;
        }

        Estudio estudio = new Estudio();

        estudio.setTitulo( estudioVO.getTitulo() );
        estudio.setEspecialidad( estudioVO.getEspecialidad() );
        estudio.setInstitucion( estudioVO.getInstitucion() );

        return estudio;
    }

    protected List<Estudio> estudioVOListToEstudioList(List<EstudioVO> list) {
        if ( list == null ) {
            return null;
        }

        List<Estudio> list1 = new ArrayList<Estudio>( list.size() );
        for ( EstudioVO estudioVO : list ) {
            list1.add( estudioVOToEstudio( estudioVO ) );
        }

        return list1;
    }

    protected Experiencia experienciaVOToExperiencia(ExperienciaVO experienciaVO) {
        if ( experienciaVO == null ) {
            return null;
        }

        Experiencia experiencia = new Experiencia();

        experiencia.setCargo( experienciaVO.getCargo() );
        experiencia.setEmpresa( experienciaVO.getEmpresa() );
        experiencia.setFechaInicio( experienciaVO.getFechaInicio() );
        experiencia.setFechaFin( experienciaVO.getFechaFin() );
        experiencia.setSalario( experienciaVO.getSalario() );
        experiencia.setNivel( experienciaVO.getNivel() );

        return experiencia;
    }

    protected List<Experiencia> experienciaVOListToExperienciaList(List<ExperienciaVO> list) {
        if ( list == null ) {
            return null;
        }

        List<Experiencia> list1 = new ArrayList<Experiencia>( list.size() );
        for ( ExperienciaVO experienciaVO : list ) {
            list1.add( experienciaVOToExperiencia( experienciaVO ) );
        }

        return list1;
    }

    protected Idioma idiomaVOToIdioma(IdiomaVO idiomaVO) {
        if ( idiomaVO == null ) {
            return null;
        }

        Idioma idioma = new Idioma();

        idioma.setIdioma( idiomaVO.getIdioma() );
        idioma.setNivel( idiomaVO.getNivel() );
        idioma.setComentario( idiomaVO.getComentario() );

        return idioma;
    }

    protected List<Idioma> idiomaVOListToIdiomaList(List<IdiomaVO> list) {
        if ( list == null ) {
            return null;
        }

        List<Idioma> list1 = new ArrayList<Idioma>( list.size() );
        for ( IdiomaVO idiomaVO : list ) {
            list1.add( idiomaVOToIdioma( idiomaVO ) );
        }

        return list1;
    }
}

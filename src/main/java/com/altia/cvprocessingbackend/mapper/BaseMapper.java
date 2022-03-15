package com.altia.cvprocessingbackend.mapper;

import java.util.List;

/**
 * La interfaz BaseMapper
 * @param <E> El tipo genérico
 * @param <V> El tipo genérico
 */
public interface BaseMapper<E,V> {

  /**
   * De entidad a VO
   * @param e la entidad
   * @return el VO
   */
  V entityToVo(E e);

  /**
   * De VO a entidad
   * @param v el VO
   * @return la entidad
   */
  E voToEntity(V v);

  /**
   * De lista de VO a lista de entidades
   * @param vs la lista de VOs
   * @return la lista de entidades
   */
  List<E> vosToEntities(List<V> vs);

  /**
   * De lista de entidades a lista de VO
   * @param es la lista de entidades
   * @return la lista de VOS
   */
  List<V> entitiesToVos(List<E> es);

}

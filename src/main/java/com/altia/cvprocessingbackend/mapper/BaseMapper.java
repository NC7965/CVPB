package com.altia.cvprocessingbackend.mapper;

import java.util.List;

public interface BaseMapper<E,V> {

  V entityToVo(E e);

  E voToEntity(V v);

  List<E> vosToEntities(List<V> vs);

  List<V> entitiesToVos(List<E> es);

}

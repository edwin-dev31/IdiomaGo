package com.LinguaNova.IdiomaGo.util.mapper.interfaces;

import java.util.List;

public interface MapperGeneric<T, I> {
	I mapTo(T t);
	T mapFrom(I i);
	List<I> mapToList(List<T> tList);
	List<T> mapFromList(List<I> iList);
}
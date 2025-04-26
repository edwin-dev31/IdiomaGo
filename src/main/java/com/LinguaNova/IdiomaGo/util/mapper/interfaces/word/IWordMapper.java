package com.LinguaNova.IdiomaGo.util.mapper.interfaces.word;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.word.WordDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.MapperGeneric;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IWordMapper extends MapperGeneric<WordEntity, WordDTO> {
	IWordMapper INSTANCE = Mappers.getMapper(IWordMapper.class);
}

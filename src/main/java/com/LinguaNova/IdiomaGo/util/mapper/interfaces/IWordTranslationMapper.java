package com.LinguaNova.IdiomaGo.util.mapper.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IWordTranslationMapper extends
	MapperGeneric<WordTranslationEntity, WordTranslationDto> {
	IWordTranslationMapper INSTANCE = Mappers.getMapper(IWordTranslationMapper.class);

}
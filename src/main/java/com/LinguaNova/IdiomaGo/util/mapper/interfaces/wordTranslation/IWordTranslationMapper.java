package com.LinguaNova.IdiomaGo.util.mapper.interfaces.wordTranslation;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.WordTranslationDTO;

import com.LinguaNova.IdiomaGo.util.mapper.interfaces.MapperGeneric;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IWordTranslationMapper extends
	MapperGeneric<WordTranslationEntity, WordTranslationDTO> {
	IWordTranslationMapper INSTANCE = Mappers.getMapper(IWordTranslationMapper.class);

}
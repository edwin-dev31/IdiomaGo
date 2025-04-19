package com.LinguaNova.IdiomaGo.util.mapper.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.IWordTranslationMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WordTranslationMapper {

	private final IWordTranslationMapper mapper = IWordTranslationMapper.INSTANCE;

	public WordTranslationDto mapTo(WordTranslationEntity entity) {
		return mapper.mapTo(entity);
	}

	public WordTranslationEntity mapFrom(WordTranslationDto dto) {
		return mapper.mapFrom(dto);
	}

	public List<WordTranslationDto> mapToList(List<WordTranslationEntity> entities) {
		return mapper.mapToList(entities);
	}

	public List<WordTranslationEntity> mapFromList(List<WordTranslationDto> dtos) {
		return mapper.mapFromList(dtos);
	}
}
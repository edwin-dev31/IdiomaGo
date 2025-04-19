package com.LinguaNova.IdiomaGo.util.mapper;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WordTranslationMapper implements Mapper<WordTranslationEntity, WordTranslationDto> {

	@Override
	public WordTranslationDto mapTo(WordTranslationEntity wordTranslationEntity) {
		if (wordTranslationEntity == null) return null;

		WordTranslationDto dto = new WordTranslationDto();
		dto.setTranslatedWord(wordTranslationEntity.getTranslatedWord());
		dto.setTranslatedExample(wordTranslationEntity.getTranslatedExample());
		dto.setTranslatedDescription(wordTranslationEntity.getTranslatedDescription());
		dto.setImageUrl(wordTranslationEntity.getImageUrl());
		return dto;
	}

	@Override
	public WordTranslationEntity mapFrom(WordTranslationDto dto) {
		if (dto == null) return null;

		WordTranslationEntity wordTranslationEntity = new WordTranslationEntity();
		wordTranslationEntity.setTranslatedWord(dto.getTranslatedWord());
		wordTranslationEntity.setTranslatedExample(dto.getTranslatedExample());
		wordTranslationEntity.setTranslatedDescription(dto.getTranslatedDescription());
		wordTranslationEntity.setImageUrl(dto.getImageUrl());

		return wordTranslationEntity;
	}

	@Override
	public List<WordTranslationDto> mapToList(List<WordTranslationEntity> wordTranslationEntities) {
		return wordTranslationEntities == null ? null :
			wordTranslationEntities.stream().map(this::mapTo).collect(Collectors.toList());
	}

	@Override
	public List<WordTranslationEntity> mapFromList(List<WordTranslationDto> dtos) {
		return dtos == null ? null :
			dtos.stream().map(this::mapFrom).collect(Collectors.toList());
	}
}

package com.LinguaNova.IdiomaGo.util.mapper;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslation;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WordTranslationMapper implements Mapper<WordTranslation, WordTranslationDto> {

	@Override
	public WordTranslationDto mapTo(WordTranslation wordTranslation) {
		if (wordTranslation == null) return null;

		WordTranslationDto dto = new WordTranslationDto();
		dto.setTranslatedWord(wordTranslation.getTranslatedWord());
		dto.setTranslatedExample(wordTranslation.getTranslatedExample());
		dto.setTranslatedDescription(wordTranslation.getTranslatedDescription());
		dto.setImageUrl(wordTranslation.getImageUrl());
		return dto;
	}

	@Override
	public WordTranslation mapFrom(WordTranslationDto dto) {
		if (dto == null) return null;

		WordTranslation wordTranslation = new WordTranslation();
		wordTranslation.setTranslatedWord(dto.getTranslatedWord());
		wordTranslation.setTranslatedExample(dto.getTranslatedExample());
		wordTranslation.setTranslatedDescription(dto.getTranslatedDescription());
		wordTranslation.setImageUrl(dto.getImageUrl());

		return wordTranslation;
	}

	@Override
	public List<WordTranslationDto> mapToList(List<WordTranslation> wordTranslations) {
		return wordTranslations == null ? null :
			wordTranslations.stream().map(this::mapTo).collect(Collectors.toList());
	}

	@Override
	public List<WordTranslation> mapFromList(List<WordTranslationDto> dtos) {
		return dtos == null ? null :
			dtos.stream().map(this::mapFrom).collect(Collectors.toList());
	}
}

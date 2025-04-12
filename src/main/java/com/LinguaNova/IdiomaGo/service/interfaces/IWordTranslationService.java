package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslation;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationId;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import java.util.List;
import java.util.Optional;

public interface IWordTranslationService {
	List<WordTranslationDto> getAll();
	Optional<WordTranslationDto> getById(WordTranslationId id);
	WordTranslationDto save(WordTranslation word);
	WordTranslationDto update(Long id, WordTranslation word);
	void delete(WordTranslationId id);
	List<WordTranslationDto> getByTranslatedWord(String translatedWord);
	List<WordTranslationDto> getByWordName(String wordName);
	List<WordTranslationDto> getByLangName(String langName);
	List<WordTranslationDto> getByLangId(Long langId);
}

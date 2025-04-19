package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import java.util.List;
import java.util.Optional;

public interface IWordTranslationService {
	List<WordTranslationDto> getAll();
	Optional<WordTranslationDto> getById(Long id);
	WordTranslationDto save(WordTranslationEntity word);
	WordTranslationDto update(Long id, WordTranslationEntity word);
	void delete(Long id);
	List<WordTranslationDto> getByLangId(Long langId);
}

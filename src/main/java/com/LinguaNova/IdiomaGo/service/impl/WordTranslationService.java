package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslation;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationId;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordTranslationService;
import com.LinguaNova.IdiomaGo.util.mapper.WordTranslationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordTranslationService implements IWordTranslationService {

	private final IWordTransalationRepository repository;
	private final WordTranslationMapper mapper;

	public WordTranslationService(IWordTransalationRepository repository, WordTranslationMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<WordTranslationDto> getAll() {
		List<WordTranslation> entities = repository.findAll();
		return mapper.mapToList(entities);
	}

	@Override
	public Optional<WordTranslationDto> getById(WordTranslationId id) {
		Optional<WordTranslation> result = repository.findById(id);
		return result.map(mapper::mapTo);
	}

	@Override
	public WordTranslationDto save(WordTranslation wordTranslation) {
		WordTranslation saved = repository.save(wordTranslation);
		return mapper.mapTo(saved);
	}

	@Override
	public WordTranslationDto update(Long id, WordTranslation word) {
		return null;
	}

	@Override
	public void delete(WordTranslationId id) {
		repository.deleteById(id);
	}

	@Override
	public List<WordTranslationDto> getByTranslatedWord(String translatedWord) {
		List<WordTranslation> list = repository.findByTranslatedWordContainingIgnoreCase(translatedWord);
		return mapper.mapToList(list);
	}

	@Override
	public List<WordTranslationDto> getByWordName(String wordName) {
		List<WordTranslation> list = repository.findByWord_NameContainingIgnoreCase(wordName);
		return mapper.mapToList(list);
	}

	@Override
	public List<WordTranslationDto> getByLangName(String langName) {
		List<WordTranslation> list = repository.findBylanguage_NameContainingIgnoreCase(langName);
		return mapper.mapToList(list);
	}

	@Override
	public List<WordTranslationDto> getByLangId(Long langId) {
		List<WordTranslation> list = repository.findBylanguage_Id(langId);
		return mapper.mapToList(list);
	}
}

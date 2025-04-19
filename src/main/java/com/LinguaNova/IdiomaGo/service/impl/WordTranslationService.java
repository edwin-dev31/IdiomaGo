package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordTranslationService;
import com.LinguaNova.IdiomaGo.util.mapper.impl.WordTranslationMapper;
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
		List<WordTranslationEntity> entities = repository.findAll();
		return mapper.mapToList(entities);
	}

	@Override
	public Optional<WordTranslationDto> getById(Long id) {
		Optional<WordTranslationEntity> result = repository.findById(id);
		return result.map(mapper::mapTo);
	}

	@Override
	public WordTranslationDto save(WordTranslationEntity wordTranslationEntity) {
		WordTranslationEntity saved = repository.save(wordTranslationEntity);
		return mapper.mapTo(saved);
	}

	@Override
	public WordTranslationDto update(Long id, WordTranslationEntity word) {
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<WordTranslationDto> getByLangId(Long langId) {
		List<WordTranslationEntity> list = repository.findBylanguage_Id(langId);
		return mapper.mapToList(list);
	}
}

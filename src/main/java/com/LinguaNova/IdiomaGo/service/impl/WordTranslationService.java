package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.ILanguageRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.CreateWordTranslationDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.WordTranslationDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordTranslationService;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import com.LinguaNova.IdiomaGo.util.mapper.impl.wordTranslation.CreateWordTranslationMapper;
import com.LinguaNova.IdiomaGo.util.mapper.impl.wordTranslation.WordTranslationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordTranslationService implements IWordTranslationService {

	private final IWordTransalationRepository repository;
	private final IWordRepository wordRepository;
	private final ILanguageRepository languageRepository;
	private final WordTranslationMapper mapper;
	private final CreateWordTranslationMapper createMapper;
	public WordTranslationService(IWordTransalationRepository repository,
		IWordRepository wordRepository, ILanguageRepository languageRepository, WordTranslationMapper mapper,
		CreateWordTranslationMapper createMapper) {
		this.repository = repository;
		this.wordRepository = wordRepository;
		this.languageRepository = languageRepository;
		this.mapper = mapper;
		this.createMapper = createMapper;
	}

	@Override
	public List<WordTranslationDTO> getAll() {
		List<WordTranslationEntity> entities = repository.findAll();
		return mapper.mapToList(entities);
	}

	@Override
	public Optional<WordTranslationDTO> getById(Long id) {
		Optional<WordTranslationEntity> result = repository.findById(id);
		return result.map(mapper::mapTo);
	}

	@Override
	public WordTranslationDTO save(CreateWordTranslationDTO wordTranslationDTO) {
		WordEntity word = wordRepository.findById(wordTranslationDTO.getWordId())
			.orElseThrow(() -> new ResourceNotFoundException("Word not found with ID: " + wordTranslationDTO.getWordId()));

		LanguageEntity language = languageRepository.findById(wordTranslationDTO.getLanguageId())
			.orElseThrow(() -> new ResourceNotFoundException("Language not found with ID: " + wordTranslationDTO.getLanguageId()));

		WordTranslationEntity entity = createMapper.mapFrom(wordTranslationDTO, word, language);

		WordTranslationEntity saved = repository.save(entity);
		return mapper.mapTo(saved);
	}


	@Override
	public WordTranslationDTO update(Long id, CreateWordTranslationDTO word) {
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<WordTranslationDTO> getByLangId(Long langId) {
		List<WordTranslationEntity> list = repository.findBylanguage_Id(langId);
		return mapper.mapToList(list);
	}
}

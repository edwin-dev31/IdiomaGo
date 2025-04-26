package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.ILanguageRepository;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.word.CreateWordDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.word.WordDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.ILanguageService;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordService;
import com.LinguaNova.IdiomaGo.util.mapper.impl.word.CreateWordMapper;
import com.LinguaNova.IdiomaGo.util.mapper.impl.word.WordMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService implements IWordService {
	private final IWordRepository repository;
	private final ILanguageRepository languageRepository;
	private final WordMapper mapper;
	private final CreateWordMapper createMapper;

	public WordService(IWordRepository repository, ILanguageRepository languageRepository, WordMapper mapper, CreateWordMapper createMapper) {
		this.repository = repository;
		this.languageRepository = languageRepository;
		this.mapper = mapper;
		this.createMapper = createMapper;
	}

	@Override
	public List<WordDTO> getAll() {
		List<WordEntity> wordEntities = repository.findAll();
		return mapper.mapToList(wordEntities);
	}

	@Override
	public Optional<WordDTO> getById(Long id) {
		return repository.findById(id)
			.map(mapper::mapTo);
	}

	@Override
	public WordDTO save(CreateWordDTO dto) {
		WordEntity wordEntity = createMapper.mapFrom(dto);
		WordEntity saved = repository.save(wordEntity);

		return mapper.mapTo(saved);
	}


	@Override
	public WordDTO update(Long id, CreateWordDTO wordDetails) {
		return repository.findById(id)
			.map(word -> {
				word.setName(wordDetails.getName());
				return mapper.mapTo(repository.save(word));
			}).orElseThrow(() -> new RuntimeException("Palabra no encontrada con ID: " + id));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

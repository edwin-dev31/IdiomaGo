package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordRepository;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService implements IWordService {

	@Autowired
	private IWordRepository repository;

	@Override
	public List<WordEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<WordEntity> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public WordEntity save(WordEntity word) {
		return repository.save(word);
	}

	@Override
	public WordEntity update(Long id, WordEntity wordDetails) {
		return repository.findById(id)
			.map(word -> {
				word.setName(wordDetails.getName());
				return repository.save(word);
			}).orElseThrow(() -> new RuntimeException("Palabra no encontrada con ID: " + id));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

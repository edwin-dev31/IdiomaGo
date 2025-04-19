package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.Word;
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
	public List<Word> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Word> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Word save(Word word) {
		return repository.save(word);
	}

	@Override
	public Word update(Long id, Word wordDetails) {
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

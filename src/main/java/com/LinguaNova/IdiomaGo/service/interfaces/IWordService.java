package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import java.util.List;
import java.util.Optional;

public interface IWordService {
	List<WordEntity> getAll();
	Optional<WordEntity> getById(Long id);
	WordEntity save(WordEntity word);
	WordEntity update(Long id, WordEntity word);
	void delete(Long id);
}


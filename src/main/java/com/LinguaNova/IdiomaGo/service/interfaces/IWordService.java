package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.Word;
import java.util.List;
import java.util.Optional;

public interface IWordService {
	List<Word> getAll();
	Optional<Word> getById(Long id);
	Word save(Word word);
	Word update(Long id, Word word);
	void delete(Long id);
}


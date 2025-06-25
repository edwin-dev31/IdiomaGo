package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.presentation.dto.word.CreateWordDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.word.WordDTO;
import java.util.List;
import java.util.Optional;

public interface IWordService {
	List<WordDTO> getAll();
	Optional<WordDTO> getById(Long id);
	WordDTO save(CreateWordDTO word);
	WordDTO update(Long id, CreateWordDTO word);
	void delete(Long id);
}


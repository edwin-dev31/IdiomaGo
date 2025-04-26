package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.language.CreateLanguageDTO;
import java.util.List;
import java.util.Optional;

public interface ILanguageService {
	List<LanguageEntity> getAll();
	Optional<LanguageEntity> getById(Long id);
	LanguageEntity save(CreateLanguageDTO languageDTO);
	LanguageEntity update(Long id, LanguageEntity languageEntity);
	void delete(Long id);
}

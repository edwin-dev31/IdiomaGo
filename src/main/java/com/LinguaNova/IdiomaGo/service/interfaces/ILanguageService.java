package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import java.util.List;
import java.util.Optional;

public interface ILanguageService {
	List<LanguageEntity> getAll();
	Optional<LanguageEntity> getById(Long id);
	LanguageEntity save(LanguageEntity languageEntity);
	LanguageEntity update(Long id, LanguageEntity languageEntity);
	void delete(Long id);
}

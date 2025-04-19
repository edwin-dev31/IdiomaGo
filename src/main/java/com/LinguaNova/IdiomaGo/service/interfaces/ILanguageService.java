package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.Language;
import java.util.List;
import java.util.Optional;

public interface ILanguageService {
	List<Language> getAll();
	Optional<Language> getById(Long id);
	Language save(Language language);
	Language update(Long id, Language language);
	void delete(Long id);
}

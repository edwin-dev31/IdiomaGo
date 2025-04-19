package com.LinguaNova.IdiomaGo.service.impl;


import com.LinguaNova.IdiomaGo.persistence.entity.Language;
import com.LinguaNova.IdiomaGo.persistence.repository.ILanguageRepository;
import com.LinguaNova.IdiomaGo.service.interfaces.ILanguageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService implements ILanguageService {

	@Autowired
	private ILanguageRepository repository;

	@Override
	public List<Language> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Language> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Language save(Language language) {
		return repository.save(language);
	}

	@Override
	public Language update(Long id, Language langDetails) {
		return repository.findById(id)
			.map(word -> {
				word.setName(langDetails.getName());
				return repository.save(word);
			}).orElseThrow(() -> new RuntimeException("Idioma no encontrado con ID: " + id));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
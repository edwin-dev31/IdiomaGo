package com.LinguaNova.IdiomaGo.service.impl;


import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.ILanguageRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.language.CreateLanguageDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.ILanguageService;
import com.LinguaNova.IdiomaGo.util.mapper.impl.language.CreateLanguageMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LanguageService implements ILanguageService {

	private final ILanguageRepository repository;
	private final CreateLanguageMapper mapper;

	public LanguageService(ILanguageRepository repository, CreateLanguageMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<LanguageEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<LanguageEntity> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public LanguageEntity save(CreateLanguageDTO languageDTO) {
		LanguageEntity languageEntity = mapper.mapFrom(languageDTO);
		return repository.save(languageEntity);
	}

	@Override
	public LanguageEntity update(Long id, LanguageEntity langDetails) {
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
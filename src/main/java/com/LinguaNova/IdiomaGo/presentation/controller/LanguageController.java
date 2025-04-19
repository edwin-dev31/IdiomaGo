package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.service.interfaces.ILanguageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/language")
public class LanguageController {
	@Autowired
	private ILanguageService service;

	@GetMapping
	public List<LanguageEntity> getAllWords() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public LanguageEntity getWordById(@PathVariable Long id) {
		return service.getById(id)
			.orElseThrow(() -> new RuntimeException("Palabra no encontrada con ID: " + id));
	}


	@PostMapping
	public LanguageEntity createWord(@RequestBody LanguageEntity lang) {
		return service.save(lang);
	}

	@PutMapping("/{id}")
	public LanguageEntity updateWord(@PathVariable Long id, @RequestBody LanguageEntity lang) {
		return service.update(id, lang);
	}

	@DeleteMapping("/{id}")
	public void deleteWord(@PathVariable Long id) {
		service.delete(id);
	}
}

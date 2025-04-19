package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.WordTranslationDto;
import com.LinguaNova.IdiomaGo.service.impl.WordTranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class WordTranslationController {

	private final WordTranslationService service;

	public WordTranslationController(WordTranslationService service) {
		this.service = service;
	}

	@GetMapping
	public List<WordTranslationDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WordTranslationDto> getById(@PathVariable Long id) {
		return service.getById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public WordTranslationDto save(@RequestBody WordTranslationEntity wordTranslationEntity) {
		return service.save(wordTranslationEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/language/id/{langId}")
	public List<WordTranslationDto> getByLanguegaWordName(@PathVariable Long langId) {
		return service.getByLangId(langId);
	}
}

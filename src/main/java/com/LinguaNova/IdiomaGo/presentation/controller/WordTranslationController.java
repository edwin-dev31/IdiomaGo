package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslation;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationId;
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

	@GetMapping("/{wordId}/{languageId}")
	public ResponseEntity<WordTranslationDto> getById(@PathVariable Long wordId, @PathVariable Long languageId) {
		WordTranslationId id = new WordTranslationId(wordId, languageId);
		return service.getById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public WordTranslationDto save(@RequestBody WordTranslation wordTranslation) {
		return service.save(wordTranslation);
	}

	@DeleteMapping("/{wordId}/{languageId}")
	public ResponseEntity<Void> delete(@PathVariable Long wordId, @PathVariable Long languageId) {
		WordTranslationId id = new WordTranslationId(wordId, languageId);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/word/translate/{name}")
	public List<WordTranslationDto> getByTranslatedWord(@PathVariable String name) {
		return service.getByTranslatedWord(name);
	}

	@GetMapping("/word/{wordName}")
	public List<WordTranslationDto> getByOriginalWordName(@PathVariable String wordName) {
		return service.getByWordName(wordName);
	}

	@GetMapping("/language/{langName}")
	public List<WordTranslationDto> getByLanguegaWordName(@PathVariable String langName) {
		return service.getByLangName(langName);
	}

	@GetMapping("/language/id/{langId}")
	public List<WordTranslationDto> getByLanguegaWordName(@PathVariable Long langId) {
		return service.getByLangId(langId);
	}
}

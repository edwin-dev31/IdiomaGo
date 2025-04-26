package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import com.LinguaNova.IdiomaGo.service.interfaces.ITranslationViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/view")
public class TranslationViewController {

	private final ITranslationViewService translationViewService;

	public TranslationViewController(ITranslationViewService translationViewService) {
		this.translationViewService = translationViewService;
	}

	// 1. Get translation by word and language code
	@GetMapping("/{word}/language/{languageCode}")
	public ResponseEntity<TranslationView> getByWordAndLanguage(
		@PathVariable String word,
		@PathVariable String languageCode
	) {
		return translationViewService.getByWordAndLanguage(word, languageCode)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search/{word}/language/{languageCode}")
	public ResponseEntity<List<TranslationView>> searchTranslationAndLanguage(
		@PathVariable String word,
		@PathVariable String languageCode
	) {
		return ResponseEntity
			.ok(translationViewService.searchTranslationAndLanguage(word, languageCode));
	}


	// 2. Get all translations of a word
	@GetMapping("/word/{word}")
	public ResponseEntity<List<TranslationView>> getAllByWord(@PathVariable String word) {
		return ResponseEntity.ok(translationViewService.getAllByWord(word));
	}

	// 3. Get all translations in a specific language
	@GetMapping("/language/{languageCode}")
	public ResponseEntity<List<TranslationView>> getAllByLanguage(@PathVariable String languageCode) {
		return ResponseEntity.ok(translationViewService.getAllByLanguage(languageCode));
	}

	// 4. Get all translations that have examples
	@GetMapping("/with-example")
	public ResponseEntity<List<TranslationView>> getAllWithExamples() {
		return ResponseEntity.ok(translationViewService.getAllWithExamples());
	}

	// 5. Search translations by keyword in description
	@GetMapping("/search-description/{keyword}")
	public ResponseEntity<List<TranslationView>> searchByDescription(@PathVariable String keyword) {
		return ResponseEntity.ok(translationViewService.searchByDescription(keyword));
	}

	// 6. Search translations by partial word
	@GetMapping("/search/{partial}")
	public ResponseEntity<List<TranslationView>> searchByPartialWord(@PathVariable String partial) {
		return ResponseEntity.ok(translationViewService.searchByPartialWord(partial));
	}
}

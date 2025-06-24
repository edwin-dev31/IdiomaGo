package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import com.LinguaNova.IdiomaGo.service.interfaces.ITranslationViewService;
import org.springframework.http.HttpStatus;
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

	@GetMapping()
	public ResponseEntity<List<TranslationView>> findAll(){
		return (ResponseEntity.ok(translationViewService.findAll()));
	}

	@GetMapping("/{word}/language/{languageCode}")
	public ResponseEntity<TranslationView> getByWordAndLanguage(
		@PathVariable String word,
		@PathVariable String languageCode
	) {
		return translationViewService.getByWordAndLanguage(word, languageCode)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search/lang")
	public ResponseEntity<?> searchByWordAndLanguages(
			@RequestParam String word,
			@RequestParam List<String> codes
	) {
		List<TranslationView> results = codes.stream()
				.map(code -> translationViewService.getOrCreateTranslation(word, code))
				.flatMap(List::stream)
				.toList();

		if (results.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No translations found.");
		}

		return ResponseEntity.ok(results);
	}


	@GetMapping("/word/{word}")
	public ResponseEntity<List<TranslationView>> getAllByWord(@PathVariable String word) {
		return ResponseEntity.ok(translationViewService.getAllByWord(word));
	}

	@GetMapping("/language/{languageCode}")
	public ResponseEntity<List<TranslationView>> getAllByLanguage(@PathVariable String languageCode) {
		return ResponseEntity.ok(translationViewService.getAllByLanguage(languageCode));
	}

	/*@GetMapping("/search/lang/{lang}")
	public ResponseEntity<List<TranslationView>> searchByLang(@PathVariable String lang) {
		return ResponseEntity.ok(translationViewService.searchByLang());
	}

	@GetMapping("/search/categories/{category}")
	public ResponseEntity<List<TranslationView>> searchByCategory() {
		return ResponseEntity.ok(translationViewService.searchByCategory());
	}

	@GetMapping("/search/description/{partial}")
	public ResponseEntity<List<TranslationView>> searchByDescription(@PathVariable String partial) {
		return ResponseEntity.ok(translationViewService.searchByDescription(partial));
	}

	@GetMapping("/search/example/{partial}")
	public ResponseEntity<List<TranslationView>> searchByPartialExample(@PathVariable String partial) {
		return ResponseEntity.ok(translationViewService.searchByPartialExample(partial));
	}

//	public ResponseEntity<List<TranslationView>> searchByPartialWord(@PathVariable String partial) {
//		return ResponseEntity.ok(translationViewService.searchByPartialWord(partial));
//	}*/
}

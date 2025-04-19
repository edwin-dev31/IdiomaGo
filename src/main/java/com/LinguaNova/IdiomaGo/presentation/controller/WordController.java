package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
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
import com.LinguaNova.IdiomaGo.service.interfaces.IWordService;

@RestController
@RequestMapping("api/word")
public class WordController {

	@Autowired
	private IWordService wordService;

	@GetMapping
	public List<WordEntity> getAllWords() {
		return wordService.getAll();
	}

	@GetMapping("/{id}")
	public WordEntity getWordById(@PathVariable Long id) {
		return wordService.getById(id)
			.orElseThrow(() -> new RuntimeException("Palabra no encontrada con ID: " + id));
	}


	@PostMapping
	public WordEntity createWord(@RequestBody WordEntity word) {
		return wordService.save(word);
	}

	@PutMapping("/{id}")
	public WordEntity updateWord(@PathVariable Long id, @RequestBody WordEntity word) {
		return wordService.update(id, word);
	}

	@DeleteMapping("/{id}")
	public void deleteWord(@PathVariable Long id) {
		wordService.delete(id);
	}
}

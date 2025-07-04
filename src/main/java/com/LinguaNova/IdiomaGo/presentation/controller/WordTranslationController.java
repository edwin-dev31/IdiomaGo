package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.CreateWordTranslationDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.UpdateWordTranslationDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.WordTranslationDTO;
import com.LinguaNova.IdiomaGo.service.impl.WordTranslationService;
import com.LinguaNova.IdiomaGo.util.exception.ErrorResponse;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import com.LinguaNova.IdiomaGo.util.exception.UnauthorizedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
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
	public List<WordTranslationDTO> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WordTranslationDTO> getById(@PathVariable Long id) {
		return service.getById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public WordTranslationDTO save(@RequestBody CreateWordTranslationDTO createWordTranslationDTO) {
		return service.save(createWordTranslationDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateTranslation(@PathVariable Long id,
											   @RequestBody UpdateWordTranslationDTO dto) {
		try {
			WordTranslationDTO updated = service.update(id, dto);
			return ResponseEntity.ok(updated);
		} catch (UnauthorizedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(new ErrorResponse(e.getMessage()));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse(e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTranslation(@PathVariable Long id,
											   @RequestParam Long userId) {
		try {
			service.delete(id, userId);
			return ResponseEntity.noContent().build();
		} catch (UnauthorizedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(new ErrorResponse(e.getMessage()));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse(e.getMessage()));
		}
	}


	@GetMapping("/language/id/{langId}")
	public List<WordTranslationDTO> getByLanguegaWordName(@PathVariable Long langId) {
		return service.getByLangId(langId);
	}
}

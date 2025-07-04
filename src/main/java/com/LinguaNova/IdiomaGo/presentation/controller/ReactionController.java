package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.presentation.dto.reaction.CreateReactionDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.reaction.ReactionDTO;
import com.LinguaNova.IdiomaGo.service.impl.ReactionService;
import com.LinguaNova.IdiomaGo.util.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService service;

    @PostMapping
    public ReactionDTO create(@RequestBody CreateReactionDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ReactionDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/word/{wordId}")
    public ResponseEntity<?> getByWordTranslation(@PathVariable Long wordId) {
        List<ReactionDTO> reactions = service.getByWordTranslationId(wordId);
        if (reactions.isEmpty()) {
            return ResponseEntity.status(404).body(new ErrorResponse("No reactions were found for the word"));
        }
        return ResponseEntity.ok(reactions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.status(404).body(new ErrorResponse("Reaction not fount"));
        }
    }
}

package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.persistence.view.WordFooterView;
import com.LinguaNova.IdiomaGo.service.impl.WordFooterViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/footer")
public class WordFooterViewController {

    private final WordFooterViewService service;

    public WordFooterViewController(WordFooterViewService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WordFooterView>> getAllFooterData() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordFooterView> getFooterDataById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

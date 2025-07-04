package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.repository.IWordFooterView;
import com.LinguaNova.IdiomaGo.persistence.view.WordFooterView;
import com.LinguaNova.IdiomaGo.service.interfaces.IWordFooterViewService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WordFooterViewService implements IWordFooterViewService {
    private final IWordFooterView wordFooterViewRepository;

    public WordFooterViewService(IWordFooterView wordFooterViewRepository) {
        this.wordFooterViewRepository = wordFooterViewRepository;
    }

    @Override
    public List<WordFooterView> findAll() {
        return wordFooterViewRepository.findAll();
    }

    @Override
    public Optional<WordFooterView> findById(Long wordTranslationId) {
        return wordFooterViewRepository.findById(wordTranslationId);
    }
}

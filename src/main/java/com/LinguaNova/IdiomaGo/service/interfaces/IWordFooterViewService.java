package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.view.WordFooterView;

import java.util.List;
import java.util.Optional;

public interface IWordFooterViewService {
    List<WordFooterView> findAll();
    Optional<WordFooterView> findById(Long id);
}

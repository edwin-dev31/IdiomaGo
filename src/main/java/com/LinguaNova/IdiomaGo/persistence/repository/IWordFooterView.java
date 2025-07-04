package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.view.WordFooterView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWordFooterView extends JpaRepository<WordFooterView, Long> {
}

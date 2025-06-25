package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWordTransalationRepository extends JpaRepository<WordTranslationEntity, Long> {
	List<WordTranslationEntity> findBylanguage_Id(Long languageId);

}
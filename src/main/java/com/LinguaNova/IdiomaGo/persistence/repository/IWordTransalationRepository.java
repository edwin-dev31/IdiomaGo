package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslation;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWordTransalationRepository extends JpaRepository<WordTranslation, WordTranslationId> {
	List<WordTranslation> findByTranslatedWordContainingIgnoreCase(String translatedWord);
	List<WordTranslation> findByWord_NameContainingIgnoreCase(String wordName);
	List<WordTranslation> findBylanguage_NameContainingIgnoreCase(String languageName);
	List<WordTranslation> findBylanguage_Id(Long languageId);

}
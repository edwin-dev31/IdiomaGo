package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITranslationView extends JpaRepository<TranslationView, Long> {

	// 1. Find a specific translation for a word in a given language
	Optional<TranslationView> findByOriginalWordAndLanguageCode(String originalWord, String languageCode);

	// 2. List all translations for a given word, sorted by language
	List<TranslationView> findByOriginalWordOrderByLanguageCode(String originalWord);

	// 3. List all translations available in a specific language, sorted by word
	List<TranslationView> findByLanguageCodeOrderByOriginalWord(String languageCode);

	// 4. Find all translations that include an example sentence
	List<TranslationView> findByTranslatedExampleIsNotNull();

	// 5. Search translations by partial match in the description (case-insensitive)
	List<TranslationView> findByTranslatedDescriptionContainingIgnoreCase(String keyword);

	// 6. Search original words by partial match (for autocomplete, etc.)
	List<TranslationView> findByOriginalWordContainingIgnoreCase(String partialWord);
}

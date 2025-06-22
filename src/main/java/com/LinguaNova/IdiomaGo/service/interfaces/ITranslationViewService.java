package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import java.util.List;
import java.util.Optional;

public interface ITranslationViewService {
	Optional<TranslationView> getByWordAndLanguage(String word, String languageCode);

	List<TranslationView> findAll();
	List<TranslationView> getOrCreateTranslation(String word, String languageCode);

	List<TranslationView> searchAllViews(String query, String languageCode);
	List<TranslationView> getAllByWord(String word);
	List<TranslationView> getAllByLanguage(String languageCode);
	List<TranslationView> getAllWithExamples();
	List<TranslationView> searchByDescription(String keyword);
	List<TranslationView> searchByPartialWord(String partialWord);
}

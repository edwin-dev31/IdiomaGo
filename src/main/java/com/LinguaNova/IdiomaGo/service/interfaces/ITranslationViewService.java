package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.SaveSingleWordTranslationDTO;

import java.util.List;
import java.util.Optional;

public interface ITranslationViewService {
	Optional<TranslationView> getByWordAndLanguage(String word, String languageCode);

	List<TranslationView> findAll();
	List<TranslationView> saveMultipleWords(String word, String languageCode, Long category);
	List<TranslationView> saveSingleWords(SaveSingleWordTranslationDTO newTranslation);
	List<TranslationView> searchAllViews(String query, String languageCode);
	List<TranslationView> getAllByWord(String word);
	List<TranslationView> getAllByLanguage(String languageCode);
	List<TranslationView> searchByLang(String lang);
	List<TranslationView> searchByCategory(long categoryId);
	List<TranslationView> searchByDescription(String partial);
	List<TranslationView> searchByPartialExample(String partial);
	List<TranslationView> searchByPartialWord(String partial);

	void importImages();
	String changeImages(Long wordTranslationId);
}

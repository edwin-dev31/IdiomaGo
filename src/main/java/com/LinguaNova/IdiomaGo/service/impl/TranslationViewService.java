package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.repository.ITranslationView;
import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import com.LinguaNova.IdiomaGo.service.interfaces.ITranslationViewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationViewService implements ITranslationViewService {

	private final ITranslationView translationViewRepository;

	public TranslationViewService(ITranslationView translationViewRepository) {
		this.translationViewRepository = translationViewRepository;
	}

	@Override
	public List<TranslationView>findAll(){
		return translationViewRepository.findAll();
	}
	@Override
	public Optional<TranslationView> getByWordAndLanguage(String word, String languageCode) {
		return translationViewRepository.findByTranslatedWordAndLanguageCode(word, languageCode);
	}

	public List<TranslationView> getOrCreateTranslation(String word, String languageCode) {
		// Paso 1: Buscar si ya existe
		List<TranslationView> results = searchAllViews(word, languageCode);
		if (!results.isEmpty()) {
			return results;
		}

		// Paso 2: Obtener wordId desde original o traducida
		Optional<Long> wordIdOpt = findWordIdByWord(word);
		if (wordIdOpt.isEmpty()) {
			return List.of(); // No existe ni como traducción ni como original
		}

		Long wordId = wordIdOpt.get();

//		TranslationView aiTranslation = generateTranslationWithAI(wordId, word, languageCode);
//		if (aiTranslation == null) {
//			return List.of();
//		}

		// Paso 4: Guardar en la base de datos
//		saveTranslation(aiTranslation);

		// Paso 5: Buscar y devolver el nuevo resultado
		return searchAllViews(word, languageCode);
	}


	public List<TranslationView> searchAllViews(String query, String languageCode) {
		List<TranslationView> matches = getAllByWord(query);

		if (matches.isEmpty()) {
			matches = translationViewRepository.findByOriginalWordIgnoreCaseOrderByLanguageCode(query);
		}

		if (matches.isEmpty()) {
			return List.of();
		}

		Long wordId = matches.get(0).getWordId();
		return translationViewRepository.findByWordIdAndLanguageCode(wordId, languageCode);
	}

	public Optional<Long> findWordIdByWord(String query) {
		List<TranslationView> matches = translationViewRepository.findByTranslatedWordIgnoreCaseOrderByLanguageCode(query);
		if (matches.isEmpty()) {
			matches = translationViewRepository.findByOriginalWordIgnoreCaseOrderByLanguageCode(query);
		}
		return matches.isEmpty() ? Optional.empty() : Optional.of(matches.get(0).getWordId());
	}

	@Override
	public List<TranslationView> getAllByWord(String word) {
		return translationViewRepository.findByTranslatedWordIgnoreCaseOrderByLanguageCode(word);
	}

	@Override
	public List<TranslationView> getAllByLanguage(String languageCode) {
		return translationViewRepository.findByLanguageCodeOrderByOriginalWord(languageCode);
	}

	@Override
	public List<TranslationView> getAllWithExamples() {
		return translationViewRepository.findByTranslatedExampleIsNotNull();
	}

	@Override
	public List<TranslationView> searchByDescription(String keyword) {
		return translationViewRepository.findByTranslatedDescriptionContainingIgnoreCase(keyword);
	}

	@Override
	public List<TranslationView> searchByPartialWord(String partialWord) {
		return translationViewRepository.findByTranslatedWordContainingIgnoreCase(partialWord);
	}
}

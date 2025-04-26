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
	public Optional<TranslationView> getByWordAndLanguage(String word, String languageCode) {
		return translationViewRepository.findByTranslatedWordAndLanguageCode(word, languageCode);
	}

	public List<TranslationView> searchTranslationAndLanguage(String query, String languageCode) {
		return translationViewRepository.findByTranslatedWordContainingIgnoreCaseAndLanguageCode(query, languageCode);
	}

	@Override
	public List<TranslationView> getAllByWord(String word) {
		return translationViewRepository.findByOriginalWordOrderByLanguageCode(word);
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

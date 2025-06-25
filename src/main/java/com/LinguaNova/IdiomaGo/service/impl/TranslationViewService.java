package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.external.images.UnsplashService;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.ITranslationView;
import com.LinguaNova.IdiomaGo.persistence.repository.IWordTransalationRepository;
import com.LinguaNova.IdiomaGo.persistence.view.TranslationView;
import com.LinguaNova.IdiomaGo.service.interfaces.ITranslationViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TranslationViewService implements ITranslationViewService {

	private final ITranslationView repository;
	private final IWordTransalationRepository iWordTransalationRepository;
	@Autowired
	private UnsplashService unsplashService;

	public TranslationViewService(ITranslationView translationViewRepository, IWordTransalationRepository iWordTransalationRepository) {
		this.repository = translationViewRepository;
        this.iWordTransalationRepository = iWordTransalationRepository;
    }

	@Override
	public List<TranslationView> findAll() {
		checkItemsImages();
		return repository.findAll();
	}

	@Override
	public Optional<TranslationView> getByWordAndLanguage(String word, String languageCode) {
		return repository.findByTranslatedWordAndLanguageCode(word, languageCode);
	}

	public List<TranslationView> getOrCreateTranslation(String word, String languageCode) {
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
			matches = repository.findByOriginalWordIgnoreCaseOrderByLanguageCode(query);
		}

		if (matches.isEmpty()) {
			return List.of();
		}

		Long wordId = matches.get(0).getWordId();
		return repository.findByWordIdAndLanguageCode(wordId, languageCode);
	}

	public Optional<Long> findWordIdByWord(String query) {
		List<TranslationView> matches = repository.findByTranslatedWordIgnoreCaseOrderByLanguageCode(query);
		if (matches.isEmpty()) {
			matches = repository.findByOriginalWordIgnoreCaseOrderByLanguageCode(query);
		}
		return matches.isEmpty() ? Optional.empty() : Optional.of(matches.get(0).getWordId());
	}

	@Override
	public List<TranslationView> getAllByWord(String word) {
		return repository.findByTranslatedWordIgnoreCaseOrderByLanguageCode(word);
	}

	@Override
	public List<TranslationView> getAllByLanguage(String languageCode) {
		return repository.findByLanguageCodeOrderByOriginalWord(languageCode);
	}

	@Override
	public List<TranslationView> searchByLang(String lang) {
		return repository.findByLanguageCodeIgnoreCase(lang);
	}

	@Override
	public List<TranslationView> searchByCategory(long categoryId) {
		return repository.findByCategoryId(categoryId);
	}

	@Override
	public List<TranslationView> searchByDescription(String partial) {
		return repository.findByTranslatedDescriptionContainingIgnoreCase(partial);
	}

	@Override
	public List<TranslationView> searchByPartialExample(String partial) {
		return repository.findByTranslatedExampleContainingIgnoreCase(partial);
	}

	@Override
	public List<TranslationView> searchByPartialWord(String partial) {
		return repository.findByTranslatedWordContainingIgnoreCase(partial);
	}

	private String searchImage(String word) {
		return UnsplashService.getImageUrlForWord(word);
	}

	private void checkItemsImages() {
		List<TranslationView> traslations = repository.findAll();
		List<WordTranslationEntity> temTraslations = new ArrayList<>();

		for (TranslationView item : traslations) {
			if (item.getImageUrl() == null || item.getImageUrl().isBlank()) {
				Long wordTranslationId = item.getWordTranslationId();
				Optional<WordTranslationEntity> temWord = iWordTransalationRepository.findById(wordTranslationId);

				temWord.ifPresent(wordTranslation -> {
					String word = wordTranslation.getWord().getName();
					String generatedUrl = searchImage(word);
					wordTranslation.setImageUrl(generatedUrl);
					temTraslations.add(wordTranslation);
				});
			}
		}

		iWordTransalationRepository.saveAll(temTraslations);
	}

}

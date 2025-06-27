package com.LinguaNova.IdiomaGo.external.words;

import com.LinguaNova.IdiomaGo.external.images.UnsplashService;
import com.LinguaNova.IdiomaGo.persistence.entity.*;
import com.LinguaNova.IdiomaGo.persistence.repository.*;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.SaveSingleWordTranslationDTO;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIWordTranslationService {

    private final OpenAIService openAIService;
    private final IWordRepository wordRepository;
    private final ILanguageRepository languageRepository;
    private final ICategoryRepository categoryRepository;
    private final IWordTransalationRepository wordTranslationRepository;

    @Autowired
    public AIWordTranslationService(OpenAIService openAIService,
            IWordRepository wordRepository,
            ILanguageRepository languageRepository,
            ICategoryRepository categoryRepository,
            IWordTransalationRepository wordTranslationRepository) {
        this.openAIService = openAIService;
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.categoryRepository = categoryRepository;
        this.wordTranslationRepository = wordTranslationRepository;
    }

    public WordTranslationEntity saveMultipleWordsIA(String word, String languageCode, Long categoryId, String imageUrl) {
        WordEntity wordEntity = findOrCreateWord(word);
        LanguageEntity language = getLanguageOrThrow(languageCode);
        CategoryEntity category = getCategoryOrThrow(categoryId);

        checkIfTranslationExists(wordEntity.getId(), language.getId());

        IAResponse response = openAIService.getWordExplanation(word, languageCode);

        return saveTranslation(wordEntity, language, category, response.getWord(), response.getExample(), response.getDescription(), imageUrl);
    }

    public WordTranslationEntity saveSingleWords(SaveSingleWordTranslationDTO dto) {
        WordEntity wordEntity = findOrCreateWord(dto.getWord());
        LanguageEntity language = getLanguageOrThrow(dto.getLanguageCode());
        CategoryEntity category = getCategoryOrThrow(dto.getCategoryId());

        checkIfTranslationExists(wordEntity.getId(), language.getId());

        String imageUrl = UnsplashService.getImageUrlForWord(dto.getWord());

        return saveTranslation(wordEntity, language, category, dto.getWord(), dto.getExample(), dto.getDescription(), imageUrl);
    }


    private WordEntity findOrCreateWord(String word) {
        return wordRepository.findByNameIgnoreCase(word)
                .orElseGet(() -> {
                    WordEntity newWord = new WordEntity();
                    newWord.setName(word);
                    return wordRepository.save(newWord);
                });
    }

    private LanguageEntity getLanguageOrThrow(String code) {
        LanguageEntity lang = languageRepository.findByCode(code);
        if (lang == null) {
            throw new ResourceNotFoundException("Language not found: " + code);
        }
        return lang;
    }

    private CategoryEntity getCategoryOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));
    }

    private void checkIfTranslationExists(Long wordId, Long languageId) {
        if (wordTranslationRepository.existsByWordIdAndLanguageId(wordId, languageId)) {
            throw new IllegalStateException("Translation already exists for this word and language.");
        }
    }

    private WordTranslationEntity saveTranslation(
            WordEntity word,
            LanguageEntity language,
            CategoryEntity category,
            String translatedWord,
            String example,
            String description,
            String imageUrl
    ) {
        WordTranslationEntity entity = new WordTranslationEntity();
        entity.setWord(word);
        entity.setLanguage(language);
        entity.setCategory(category);
        entity.setTranslatedWord(translatedWord);
        entity.setTranslatedExample(example);
        entity.setTranslatedDescription(description);
        entity.setImageUrl(imageUrl);
        return wordTranslationRepository.save(entity);
    }
}

package com.LinguaNova.IdiomaGo.external.words;

import com.LinguaNova.IdiomaGo.external.images.UnsplashService;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.SaveMultipleWordTranslationDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.SaveSingleWordTranslationDTO;
import com.LinguaNova.IdiomaGo.service.impl.WordTranslationService;
import com.LinguaNova.IdiomaGo.util.Visibility;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIWordTranslationService {

    private final OpenAIService openAIService;
    private final IUserRepository userRepository;
    private final WordTranslationService wordTranslationService;

    @Autowired
    public AIWordTranslationService(OpenAIService openAIService,
                                    IUserRepository userRepository,
                                    WordTranslationService wordTranslationService) {
        this.openAIService = openAIService;
        this.userRepository = userRepository;
        this.wordTranslationService = wordTranslationService;
    }

    public UserEntity getOrThrowUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
    }

    public WordTranslationEntity saveMultipleWordsIA(SaveMultipleWordTranslationDTO dto) {

        UserEntity user = getOrThrowUser(dto.getUserId());
        IAResponse response = openAIService.getWordExplanation(dto.getWord(), dto.getLanguageCode());
        String imageUrl = UnsplashService.getImageUrlForWord(dto.getWord());

        return wordTranslationService.saveTranslationFull(
                user,  dto.getWord(), response.getWord(), response.getExample(), response.getDescription(),
                dto.getLanguageCode(), dto.getCategoryId(), imageUrl, Visibility.PUBLIC);
    }

    public WordTranslationEntity saveSingleWords(SaveSingleWordTranslationDTO dto) {
        UserEntity user = getOrThrowUser(dto.getUser());
        String imageUrl = UnsplashService.getImageUrlForWord(dto.getWord());

        return wordTranslationService.saveTranslationFull(
                user, dto.getWord(), dto.getWord(), dto.getExample(), dto.getDescription(),
                dto.getLanguageCode(), dto.getCategoryId(), imageUrl, dto.getVisibility()
        );
    }
}

package com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation;

import com.LinguaNova.IdiomaGo.util.Visibility;

public class SaveMultipleWordTranslationDTO {
    private Long userId;
    private String word;
    private String languageCode;
    private Long categoryId;

    public SaveMultipleWordTranslationDTO(Long userId, String word, String languageCode, Long categoryId) {
        this.userId = userId;
        this.word = word;
        this.languageCode = languageCode;
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

}

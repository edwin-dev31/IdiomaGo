package com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation;

import java.util.List;

public class CreateMultipleWordTranslationDTO {
    private Long userId;
    private String word;
    private Long categoryId;
    private List<String> languageCodes;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getLanguageCodes() {
        return languageCodes;
    }

    public void setLanguageCodes(List<String> languageCodes) {
        this.languageCodes = languageCodes;
    }
}

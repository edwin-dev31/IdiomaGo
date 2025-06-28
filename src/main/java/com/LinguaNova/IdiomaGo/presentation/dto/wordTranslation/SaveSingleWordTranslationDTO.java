package com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.util.Visibility;

public class SaveSingleWordTranslationDTO {
    private Long user;
    private String word;
    private String languageCode;
    private Long categoryId;
    private String description;
    private String example;
    private Visibility visibility;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}

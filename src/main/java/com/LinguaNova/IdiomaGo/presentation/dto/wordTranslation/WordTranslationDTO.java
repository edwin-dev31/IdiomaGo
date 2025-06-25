package com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class WordTranslationDTO {
	private Long id;
	private String translatedWord;
	private String translatedExample;
	private String translatedDescription;
	private String imageUrl;
	private String audioUrl;
	private LocalDateTime createdAt = LocalDateTime.now();
	private Set<UserEntity> favoritedBy = new HashSet<>();


	public WordTranslationDTO() {
	}

	public WordTranslationDTO(Long id, WordEntity word, LanguageEntity language,
		String translatedWord,
		String translatedExample, String translatedDescription, String imageUrl, String audioUrl,
		LocalDateTime createdAt, Set<UserEntity> favoritedBy) {
		this.id = id;
		this.translatedWord = translatedWord;
		this.translatedExample = translatedExample;
		this.translatedDescription = translatedDescription;
		this.imageUrl = imageUrl;
		this.audioUrl = audioUrl;
		this.createdAt = createdAt;
		this.favoritedBy = favoritedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTranslatedWord() {
		return translatedWord;
	}

	public void setTranslatedWord(String translatedWord) {
		this.translatedWord = translatedWord;
	}

	public String getTranslatedExample() {
		return translatedExample;
	}

	public void setTranslatedExample(String translatedExample) {
		this.translatedExample = translatedExample;
	}

	public String getTranslatedDescription() {
		return translatedDescription;
	}

	public void setTranslatedDescription(String translatedDescription) {
		this.translatedDescription = translatedDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<UserEntity> getFavoritedBy() {
		return favoritedBy;
	}

	public void setFavoritedBy(
		Set<UserEntity> favoritedBy) {
		this.favoritedBy = favoritedBy;
	}
}

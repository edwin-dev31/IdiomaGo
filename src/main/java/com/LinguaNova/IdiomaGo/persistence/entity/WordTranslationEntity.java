package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "word_translation")
public class WordTranslationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "word_id")
	private WordEntity word;

	@ManyToOne(optional = false)
	@JoinColumn(name = "language_id")
	private LanguageEntity language;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@Column(nullable = false)
	private String translatedWord;

	private String translatedExample;

	private String translatedDescription;

	private String imageUrl;

	private String audioUrl;

	private LocalDateTime createdAt = LocalDateTime.now();

	@ManyToMany(mappedBy = "favorites")
	private Set<UserEntity> favoritedBy = new HashSet<>();

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public WordEntity getWord() {
		return word;
	}

	public void setWord(WordEntity word) {
		this.word = word;
	}

	public LanguageEntity getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEntity languageEntity) {
		this.language = languageEntity;
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
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
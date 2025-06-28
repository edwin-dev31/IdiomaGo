package com.LinguaNova.IdiomaGo.persistence.entity;

import com.LinguaNova.IdiomaGo.util.Visibility;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "word_translation")
public class WordTranslationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity user;

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

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Visibility visibility;


	private LocalDateTime createdAt = LocalDateTime.now();

	@ManyToMany(mappedBy = "favorites")
	private Set<UserEntity> favoritedBy = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
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

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
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

	public void setFavoritedBy(Set<UserEntity> favoritedBy) {
		this.favoritedBy = favoritedBy;
	}
}
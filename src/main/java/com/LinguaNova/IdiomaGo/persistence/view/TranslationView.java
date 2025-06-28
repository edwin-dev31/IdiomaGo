package com.LinguaNova.IdiomaGo.persistence.view;

import com.LinguaNova.IdiomaGo.util.Visibility;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_translations")
public class TranslationView {
	@Id
	private Long wordTranslationId;
	private Long userId;
	private Long wordId;
	private String originalWord;

	private Long languageId;
	private String languageName;
	private String languageCode;

	private Long categoryId;
	private String categoryName;

	private String translatedWord;
	private String translatedExample;
	private String translatedDescription;
	private String imageUrl;
	private String audioUrl;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Visibility visibility;
	private LocalDateTime createdAt;

	public Long getWordId() {
		return wordId;
	}
	public String getOriginalWord() {
		return originalWord;
	}

	public Long getLanguageId() {
		return languageId;
	}
	public String getLanguageName() {
		return languageName;
	}
	public String getLanguageCode() {
		return languageCode;
	}

	public Long getWordTranslationId() {
		return wordTranslationId;
	}
	public String getTranslatedWord() {
		return translatedWord;
	}
	public String getTranslatedExample() {
		return translatedExample;
	}
	public String getTranslatedDescription() {
		return translatedDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}


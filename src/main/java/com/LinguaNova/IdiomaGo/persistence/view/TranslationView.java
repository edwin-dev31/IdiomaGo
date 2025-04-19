package com.LinguaNova.IdiomaGo.persistence.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_translations")
public class TranslationView {
	@Id
	private Long translationId;

	private Long wordId;
	private String originalWord;

	private Long languageId;
	private String languageCode;

	private String translatedWord;
	private String translatedExample;
	private String translatedDescription;
	private String imageUrl;
	private String audioUrl;
	private LocalDateTime createdAt;

	public Long getTranslationId() {
		return translationId;
	}

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
		return languageCode;
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
}


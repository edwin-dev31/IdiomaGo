package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "word_translation")
public class WordTranslation {
	@EmbeddedId
	private WordTranslationId id;

	@ManyToOne
	@MapsId("wordId")
	@JoinColumn(name = "word_id")
	private Word word;

	@ManyToOne
	@MapsId("languageId")
	@JoinColumn(name = "language_id")
	private Language language;

	private String translatedWord;
	private String translatedExample;
	private String translatedDescription;
	private String imageUrl;

	public WordTranslationId getId() {
		return id;
	}

	public void setId(WordTranslationId id) {
		this.id = id;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
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
}
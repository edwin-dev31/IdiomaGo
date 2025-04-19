package com.LinguaNova.IdiomaGo.presentation.dto;

public class WordTranslationDto {
	private String translatedWord;
	private String translatedExample;
	private String translatedDescription;
	private String imageUrl;

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

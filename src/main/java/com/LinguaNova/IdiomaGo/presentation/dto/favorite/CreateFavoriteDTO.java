package com.LinguaNova.IdiomaGo.presentation.dto.favorite;

public class CreateFavoriteDTO {
	private Long userId;
	private Long wordTranslationId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWordTranslationId() {
		return wordTranslationId;
	}

	public void setWordTranslationId(Long wordTranslationId) {
		this.wordTranslationId = wordTranslationId;
	}
}

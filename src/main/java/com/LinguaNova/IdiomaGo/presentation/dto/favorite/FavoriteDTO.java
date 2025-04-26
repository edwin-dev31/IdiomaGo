package com.LinguaNova.IdiomaGo.presentation.dto.favorite;

import java.time.LocalDateTime;

public class FavoriteDTO {
	private Long userId;
	private Long wordTranslationId;
	private LocalDateTime createdAt;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

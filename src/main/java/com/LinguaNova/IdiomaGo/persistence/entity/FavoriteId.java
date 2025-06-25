package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteId implements Serializable {

	private Long userId;
	private Long wordTranslationId;

	public FavoriteId() {}

	public FavoriteId(Long userId, Long wordTranslationId) {
		this.userId = userId;
		this.wordTranslationId = wordTranslationId;
	}

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

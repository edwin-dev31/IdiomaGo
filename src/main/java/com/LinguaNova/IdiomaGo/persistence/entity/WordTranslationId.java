package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

// WordTranslationId.java
@Embeddable
public class WordTranslationId implements Serializable {
	private Long wordId;
	private Long languageId;

	public WordTranslationId() {
	}


	public WordTranslationId(Long wordId, Long languageId) {
		this.wordId = wordId;
		this.languageId = languageId;
	}
}
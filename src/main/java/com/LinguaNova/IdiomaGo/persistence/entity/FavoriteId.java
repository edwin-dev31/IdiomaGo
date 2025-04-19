package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteId implements Serializable {
	private Long userId;
	private Long wordTranslationId;

	// Constructores, equals() y hashCode()
}

package com.LinguaNova.IdiomaGo.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class FavoriteEntity {

	@EmbeddedId
	private FavoriteId id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@ManyToOne
	@MapsId("wordTranslationId")
	@JoinColumn(name = "word_translation_id")
	private WordTranslationEntity wordTranslation;

	private LocalDateTime createdAt = LocalDateTime.now();

	public FavoriteId getId() {
		return id;
	}

	public void setId(FavoriteId id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public WordTranslationEntity getWordTranslation() {
		return wordTranslation;
	}

	public void setWordTranslation(
		WordTranslationEntity wordTranslation) {
		this.wordTranslation = wordTranslation;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

// Getters y setters
}

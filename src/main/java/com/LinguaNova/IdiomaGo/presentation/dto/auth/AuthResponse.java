package com.LinguaNova.IdiomaGo.presentation.dto.auth;

public class AuthResponse {
	private Long userId;
	private String token;
	public AuthResponse(Long userId, String token) { this.userId = userId; this.token = token; }
	public String getToken() { return token; }

	public Long getUserId() {
		return userId;
	}
}

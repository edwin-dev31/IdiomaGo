package com.LinguaNova.IdiomaGo.presentation.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequest {
	private String email;
	private String password;
}

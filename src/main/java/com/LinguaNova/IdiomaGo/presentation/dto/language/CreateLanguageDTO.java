package com.LinguaNova.IdiomaGo.presentation.dto.language;

import jakarta.validation.constraints.NotBlank;

public class CreateLanguageDTO {
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Code is required")
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

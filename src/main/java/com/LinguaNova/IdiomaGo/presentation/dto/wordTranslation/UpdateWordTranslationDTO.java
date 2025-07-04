package com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateWordTranslationDTO {
    private Long userId;
    private String translatedWord;
    private String translatedExample;
    private String translatedDescription;
}

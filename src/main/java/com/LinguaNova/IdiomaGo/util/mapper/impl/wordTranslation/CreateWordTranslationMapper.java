package com.LinguaNova.IdiomaGo.util.mapper.impl.wordTranslation;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordTranslationEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.wordTranslation.CreateWordTranslationDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.wordTranslation.ICreateWordTranslationMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateWordTranslationMapper {
	private final ICreateWordTranslationMapper mapper = ICreateWordTranslationMapper.INSTANCE;

	public WordTranslationEntity mapFrom(CreateWordTranslationDTO entity, WordEntity word, LanguageEntity language) {
		return mapper.mapFrom(entity, word, language);
	}
}

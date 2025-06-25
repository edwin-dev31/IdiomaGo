package com.LinguaNova.IdiomaGo.util.mapper.impl.language;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.language.CreateLanguageDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.language.ICreateLanguageMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateLanguageMapper {
	public ICreateLanguageMapper mapper = ICreateLanguageMapper.INSTANCE;

	public LanguageEntity mapFrom(CreateLanguageDTO createDto){
		return mapper.mapFrom(createDto);
	}
}
package com.LinguaNova.IdiomaGo.util.mapper.impl.word;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.word.CreateWordDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.word.ICreateWordMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateWordMapper {
	public ICreateWordMapper mapper = ICreateWordMapper.INSTANCE;

	public WordEntity mapFrom(CreateWordDTO createDto){
		return mapper.mapFrom(createDto);
	}
}

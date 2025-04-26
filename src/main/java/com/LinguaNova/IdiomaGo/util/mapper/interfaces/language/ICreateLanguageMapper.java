package com.LinguaNova.IdiomaGo.util.mapper.interfaces.language;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.language.CreateLanguageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ICreateLanguageMapper {
	ICreateLanguageMapper INSTANCE = Mappers.getMapper(ICreateLanguageMapper.class);

	LanguageEntity mapFrom(CreateLanguageDTO createDto);
}

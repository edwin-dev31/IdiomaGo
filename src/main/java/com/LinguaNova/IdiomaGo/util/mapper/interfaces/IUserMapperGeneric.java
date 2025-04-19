package com.LinguaNova.IdiomaGo.util.mapper.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUserMapperGeneric extends MapperGeneric<UserEntity, UserDto> {
	IUserMapperGeneric INSTANCE = Mappers.getMapper(IUserMapperGeneric.class);
}

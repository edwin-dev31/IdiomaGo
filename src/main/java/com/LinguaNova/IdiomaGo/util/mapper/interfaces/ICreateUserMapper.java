package com.LinguaNova.IdiomaGo.util.mapper.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ICreateUserMapper {
	ICreateUserMapper INSTANCE = Mappers.getMapper(ICreateUserMapper.class);

	UserEntity mapFrom(CreateUserDto createUserDto);
}

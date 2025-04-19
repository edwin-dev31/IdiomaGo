package com.LinguaNova.IdiomaGo.util.mapper.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.UserDto;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.IUserMapperGeneric;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	private final IUserMapperGeneric mapper = IUserMapperGeneric.INSTANCE;
	public UserDto mapTo(UserEntity entity) {
		return mapper.mapTo(entity);
	}

	public UserEntity mapFrom(UserDto dto) {
		return mapper.mapFrom(dto);
	}

	public List<UserDto> mapToList(List<UserEntity> entities) {
		return mapper.mapToList(entities);
	}

	public List<UserEntity> mapFromList(List<UserDto> dtos) {
		return mapper.mapFromList(dtos);
	}
}

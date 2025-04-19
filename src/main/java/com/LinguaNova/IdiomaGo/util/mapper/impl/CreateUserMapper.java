package com.LinguaNova.IdiomaGo.util.mapper.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.CreateUserDto;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.ICreateUserMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserMapper {
	public ICreateUserMapper mapper = ICreateUserMapper.INSTANCE;

	public UserEntity mapFrom(CreateUserDto createUserDto){
		return mapper.mapFrom(createUserDto);
	}
}

package com.LinguaNova.IdiomaGo.util.mapper.impl.user;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.CreateUserDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.user.ICreateUserMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserMapper {
	public ICreateUserMapper mapper = ICreateUserMapper.INSTANCE;

	public UserEntity mapFrom(CreateUserDTO createUserDto){
		return mapper.mapFrom(createUserDto);
	}
}

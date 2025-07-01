package com.LinguaNova.IdiomaGo.util.mapper.impl.user;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserUpdateDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.user.IUpdateUserMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserMapper {
	public IUpdateUserMapper mapper = IUpdateUserMapper.INSTANCE;

	public UserUpdateDTO mapTo(UserEntity userEntity){
		return mapper.mapTo(userEntity);
	}

	public UserUpdateDTO mapToUpdate(UserDTO userEntity){
		return mapper.mapToUpdate(userEntity);
	}
	public UserDTO mapFrom(UpdateUserMapper updateUserMapper){
		return mapper.mapFrom(updateUserMapper);
	}
}

package com.LinguaNova.IdiomaGo.util.mapper.impl.user;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.user.IUserMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper {
	@Override
	public UserDTO mapTo(UserEntity entity) {
		return INSTANCE.mapTo(entity);
	}
	@Override
	public UserEntity mapFrom(UserDTO dto) {
		return INSTANCE.mapFrom(dto);
	}
	@Override
	public List<UserDTO> mapToList(List<UserEntity> entities) {
		return INSTANCE.mapToList(entities);
	}
	@Override
	public List<UserEntity> mapFromList(List<UserDTO> dtos) {
		return INSTANCE.mapFromList(dtos);
	}
}

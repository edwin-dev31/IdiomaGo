package com.LinguaNova.IdiomaGo.util.mapper.interfaces.user;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserUpdateDTO;
import com.LinguaNova.IdiomaGo.util.mapper.impl.user.UpdateUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUpdateUserMapper {
	IUpdateUserMapper INSTANCE = Mappers.getMapper(IUpdateUserMapper.class);
	UserDTO mapFrom(UpdateUserMapper updateUserMapper);
	UserUpdateDTO mapTo(UserEntity updateUserMapper);
	UserUpdateDTO mapToUpdate(UserDTO updateUserMapper);
}

package com.LinguaNova.IdiomaGo.util.mapper.interfaces.user;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.MapperGeneric;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUserMapper extends MapperGeneric<UserEntity, UserDTO> {
	IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
}

package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.CreateUserDto;
import com.LinguaNova.IdiomaGo.presentation.dto.UserDto;
import java.util.List;
import java.util.Optional;

public interface IUserService {
	List<UserDto> getAll();
	Optional<UserDto> getById(Long id);
	UserDto save(CreateUserDto word);
	UserDto update(Long id, CreateUserDto word);
	void delete(Long id);
}

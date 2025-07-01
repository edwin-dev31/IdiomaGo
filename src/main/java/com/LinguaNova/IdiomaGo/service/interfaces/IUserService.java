package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.CreateUserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
	List<UserDTO> findAll();
	Optional<UserDTO> findById(Long id);
	Optional<UserEntity> findByEmail(String email);
	UserDTO save(CreateUserDTO user);
	UserDTO update(Long userId, UserUpdateDTO user);
	void delete(Long id);
}

package com.LinguaNova.IdiomaGo.service.interfaces;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.user.CreateUserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {
	List<UserDTO> getAll();
	Optional<UserDTO> getById(Long id);
	Optional<UserEntity> getByEmail(String email);
	UserDTO save(CreateUserDTO user);
	UserDTO update(UserEntity user);
	void delete(Long id);
}

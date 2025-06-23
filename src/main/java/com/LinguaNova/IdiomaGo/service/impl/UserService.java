package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.LanguageEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.user.CreateUserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.IUserService;
import com.LinguaNova.IdiomaGo.util.exception.DuplicateResourceException;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import com.LinguaNova.IdiomaGo.util.mapper.impl.user.CreateUserMapper;
import com.LinguaNova.IdiomaGo.util.mapper.impl.user.UserMapper;
import java.util.List;
import java.util.Optional;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	private final IUserRepository repository;
	private final UserMapper userMapper;
	private final CreateUserMapper createUserMapper;
	private final PasswordEncoder passwordEncoder;

	public UserService(IUserRepository repository, UserMapper userMapper,
		CreateUserMapper createUserMapper, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.userMapper = userMapper;
		this.createUserMapper = createUserMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<UserDTO> getAll() {
		return userMapper.mapToList(repository.findAll());
	}

	@Override
	public Optional<UserDTO> getById(Long id) {
		return repository.findById(id)
			.map(userMapper::mapTo);
	}

	@Override
	public Optional<UserDTO> getByEmail(String userName) {
		return repository.findByEmail(userName)
			.map(userMapper::mapTo);
	}

	@Override
	public UserDTO save(CreateUserDTO dto) {
		UserEntity entity = createUserMapper.mapFrom(dto);
		if (repository.findByUsername(dto.getUsername()).isPresent()){
			throw new DuplicateResourceException("Username already exists: " + dto.getUsername());
		}
		if (repository.findByEmail(dto.getEmail()).isPresent()){
			throw new DuplicateResourceException("Email already exists: " + dto.getEmail());
		}

		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		UserEntity saved = repository.save(entity);
		return userMapper.mapTo(saved);
	}

	@Override
	public UserDTO update(Long id, CreateUserDTO dto) {
		return repository.findById(id)
			.map(user -> {
				user.setUsername(dto.getUsername());
				user.setEmail(dto.getEmail());
				user.setPassword(passwordEncoder.encode(dto.getPassword()));
				UserEntity updated = repository.save(user);
				return userMapper.mapTo(updated);
			})
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

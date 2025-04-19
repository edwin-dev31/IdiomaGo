package com.LinguaNova.IdiomaGo.service.impl;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.presentation.dto.CreateUserDto;
import com.LinguaNova.IdiomaGo.presentation.dto.UserDto;
import com.LinguaNova.IdiomaGo.service.interfaces.IUserService;
import com.LinguaNova.IdiomaGo.util.mapper.impl.CreateUserMapper;
import com.LinguaNova.IdiomaGo.util.mapper.impl.UserMapper;
import java.util.List;
import java.util.Optional;
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
	public List<UserDto> getAll() {
		return userMapper.mapToList(repository.findAll());
	}

	@Override
	public Optional<UserDto> getById(Long id) {
		return repository.findById(id)
			.map(userMapper::mapTo);
	}

	@Override
	public UserDto save(CreateUserDto dto) {
		UserEntity entity = createUserMapper.mapFrom(dto);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		UserEntity saved = repository.save(entity);
		return userMapper.mapTo(saved);
	}

	@Override
	public UserDto update(Long id, CreateUserDto dto) {
		return repository.findById(id)
			.map(user -> {
				user.setUsername(dto.getUsername());
				user.setEmail(dto.getEmail());
				user.setPassword(passwordEncoder.encode(dto.getPassword()));
				UserEntity updated = repository.save(user);
				return userMapper.mapTo(updated);
			})
			.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

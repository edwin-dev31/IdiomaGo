package com.LinguaNova.IdiomaGo.config.jwt;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import com.LinguaNova.IdiomaGo.persistence.repository.IUserRepository;
import com.LinguaNova.IdiomaGo.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

	private final IUserRepository userRepository;

	@Autowired
	public CustomUserDetails(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("Searching user in DB: " + email + " nOY");

		UserEntity userEntity = userRepository.findByEmail(email)
			.orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));

		System.out.println("USEEEEER");
		System.out.println(userEntity);
		return User.withUsername(userEntity.getEmail())
			.password(userEntity.getPassword())
			.roles("USER")
			.build();
	}
}

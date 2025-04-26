package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.config.jwt.JwtUtil;
import com.LinguaNova.IdiomaGo.presentation.dto.auth.AuthRequest;
import com.LinguaNova.IdiomaGo.presentation.dto.auth.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authManager;
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
		this.authManager = authManager;
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		var auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
		authManager.authenticate(auth);
		var userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		var jwt = jwtUtil.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
}



package com.LinguaNova.IdiomaGo.presentation.controller;

import com.LinguaNova.IdiomaGo.config.jwt.JwtUtil;
import com.LinguaNova.IdiomaGo.presentation.dto.auth.AuthRequest;
import com.LinguaNova.IdiomaGo.presentation.dto.auth.AuthResponse;
import com.LinguaNova.IdiomaGo.presentation.dto.user.CreateUserDTO;
import com.LinguaNova.IdiomaGo.presentation.dto.user.UserDTO;
import com.LinguaNova.IdiomaGo.service.interfaces.IUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authManager;
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;
	private final IUserService userService;

	public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserDetailsService userDetailsService, IUserService userService) {
		this.authManager = authManager;
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		var auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
		authManager.authenticate(auth);

		var userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		var jwt = jwtUtil.generateToken(userDetails.getUsername());
		System.out.println(jwt);
		return ResponseEntity.ok(new AuthResponse(jwt));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody CreateUserDTO dto) {

		UserDTO created = userService.save(dto);
		System.out.println(created);

		var auth = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
		authManager.authenticate(auth);

		var userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
		var jwt = jwtUtil.generateToken(userDetails.getUsername());
		System.out.println(jwt);
		return ResponseEntity.ok(new AuthResponse(jwt));
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("token", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setMaxAge(0); // Elimina la cookie

		response.addCookie(cookie);
		return ResponseEntity.ok(Map.of("message", "Sesión cerrada"));
	}
}



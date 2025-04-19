package com.LinguaNova.IdiomaGo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
			.authorizeHttpRequests(request -> {
				request.requestMatchers(HttpMethod.GET,"/",
					"/api/translations/word/translate/**").permitAll();
				request
					.anyRequest()
					.authenticated();
			})
			.formLogin(Customizer.withDefaults())
			.oauth2Login(Customizer.withDefaults())
			.build();
	}
}

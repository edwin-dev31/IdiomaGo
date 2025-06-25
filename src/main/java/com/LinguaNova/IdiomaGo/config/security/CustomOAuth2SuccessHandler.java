package com.LinguaNova.IdiomaGo.config.security;

import com.LinguaNova.IdiomaGo.config.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.ServletException;
import java.io.IOException;


@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
		HttpServletResponse response,
		Authentication authentication)
		throws IOException, ServletException {
		OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
		String email = oauthUser.getAttribute("email");

		String token = jwtUtil.generateToken(email);

		/*String redirectUrl = "http://localhost:5173/oauth2-redirect?token=" + token;
		response.sendRedirect(redirectUrl);

		System.out.println();
		System.out.println(email);
		System.out.println(token);
		System.out.println(redirectUrl);

		System.out.println();
		
		 */
	}
}

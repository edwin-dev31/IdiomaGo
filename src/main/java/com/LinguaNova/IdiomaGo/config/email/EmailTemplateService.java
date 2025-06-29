package com.LinguaNova.IdiomaGo.config.email;

import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService {

    public String buildVerificationEmail(String userName, String token) {
		String url = "http://localhost:1731/idiomago/auth/verify-email?token=" + token;


        return """
			<html>
			<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
				<div style="max-width: 600px; margin: auto; background-color: #fff; padding: 30px; border-radius: 8px;">
					<h2 style="color: #2c3e50;">Bienvenido a IdiomaGo, %s!</h2>
					<p style="font-size: 16px;">Gracias por registrarte. Para activar tu cuenta, por favor haz clic en el botón de abajo:</p>
					<p style="text-align: center; margin: 30px 0;">
						<a href="%s" style="background-color: #3498db; color: white; padding: 12px 25px; text-decoration: none; border-radius: 5px;">Confirmar correo</a>
					</p>
					<p style="font-size: 14px; color: #555;">Si no te registraste, puedes ignorar este correo.</p>
				</div>
			</body>
			</html>
		""".formatted(userName, url);
    }
}

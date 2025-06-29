package com.LinguaNova.IdiomaGo.config.email;

public interface EmailSender {
	void sendEmail(String to, String subject, String content);
}

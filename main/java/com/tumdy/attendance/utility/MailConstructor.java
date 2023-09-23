package com.tumdy.attendance.utility;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;



@Component
@RequiredArgsConstructor
public class MailConstructor {
	
	private final Environment env;
	
	public SimpleMailMessage constructSimpleMail(String to,String subject,String text) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(env.getProperty("support.mail"));
		email.setTo(to);
		email.setSubject(subject);
		email.setText(text);
		return email;
	}
	
	

}

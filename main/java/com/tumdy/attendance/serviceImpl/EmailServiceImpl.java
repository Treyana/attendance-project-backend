package com.tumdy.attendance.serviceImpl;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tumdy.attendance.payload.SimpleEmailRequest;
import com.tumdy.attendance.service.EmailService;
import com.tumdy.attendance.utility.MailConstructor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
	
	private final JavaMailSender javasender;
	private final MailConstructor mailConstructor;
	@Override
	public void sendEmail(SimpleEmailRequest email) {

		SimpleMailMessage mail = mailConstructor.constructSimpleMail(email.getTo(), email.getSubject(), email.getText());
		
		javasender.send(mail);
		
	}
	
	

}

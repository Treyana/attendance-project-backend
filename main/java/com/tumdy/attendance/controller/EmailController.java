package com.tumdy.attendance.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tumdy.attendance.payload.SimpleEmailRequest;
import com.tumdy.attendance.service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
	
	private final EmailService emailService;
	
	@PostMapping("/contact")
	public ResponseEntity<String> sendEmail(@RequestBody SimpleEmailRequest emailRequest){
		
		emailService.sendEmail(emailRequest);
		return ResponseEntity.ok("Email Sent");
	}

}

package com.tumdy.attendance.service;

import com.tumdy.attendance.payload.SimpleEmailRequest;

public interface EmailService {
	void sendEmail(SimpleEmailRequest email);
}

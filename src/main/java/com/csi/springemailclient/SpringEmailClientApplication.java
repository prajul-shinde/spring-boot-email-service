package com.csi.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//	service.sendSimpleEmail("dongare.pradip2014@gmail.com","hi pradip have a nice day","timepass");
		service.sendEmailWithAttachment
				("dongare.pradip2014@gmail.com", "hi pradip have a nice day checkout my resume",
						"java developer resume",
						"D:\\documents\\resumes\\Resume-prajul_shinde.pdf");
	}

}

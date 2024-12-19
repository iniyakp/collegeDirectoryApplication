package org.jsp.cda.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	JavaMailSender javaMailSender() {
		JavaMailSenderImpl jmsi=new JavaMailSenderImpl();
		jmsi.setHost("smtp.gmail.com"); //SMTP ---->Simple Mail Transfer Protocal
		jmsi.setPort(587); //port number for mail
		jmsi.setUsername("iniyakp06@gmail.com");
		jmsi.setPassword("kshq gmvd hvwa uvfn");
		
		Properties props=jmsi.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug","true");
		
		return jmsi;
	}

}

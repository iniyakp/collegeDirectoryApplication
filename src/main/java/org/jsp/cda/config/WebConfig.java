package org.jsp.cda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {
	
	@Bean
	WebMvcConfigurer webMvcConfigurer() {
		return new  WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET","POST","DELETE","PATCH").allowedOrigins("*");
			}
		};
	}

}

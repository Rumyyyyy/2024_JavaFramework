package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter012Application {

	public static void main(String[] args) {
		// SpringApplication.run(Chapter012Application.class, args);
		
		SpringApplication application = 
				new SpringApplication(Chapter012Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
		System.out.println("유한대학교 3-1반 스프링부트");
	}

}

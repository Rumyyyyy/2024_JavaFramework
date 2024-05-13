package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;

@WebMvcTest
public class BoardControllerTest {
	@Autowired
	private Environment env;
	
	@Test
	void testMethod() {
		System.out.println("이름 : "+env.getProperty("author.name"));
		System.out.println("나이 : "+env.getProperty("author.age"));
		System.out.println("나이 : "+env.getProperty("author.nation"));
	}
}

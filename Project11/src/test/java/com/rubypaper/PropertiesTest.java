package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.persistence.BoardDAO;
import com.rubypaper.service.BoardService;

@SpringBootTest(properties={"author.name=kimareum",
							"author.age=22",
							"author.nation=Korea"},
				classes= {BoardService.class, BoardDAO.class})
public class PropertiesTest {
	
	@Autowired // 모든 변수 값을 다 갖고 있어 간단
	private Environment env; 
	@Test
	void testMethod() {
		// assertTrue(true);
//		System.out.println("이름: "+name);
//		System.out.println("나이: "+age);
		
		System.out.println("이름: "+env.getProperty("author.name"));
		System.out.println("나이: "+env.getProperty("author.age"));
		System.out.println("나라: "+env.getProperty("author.nation"));
	}
}

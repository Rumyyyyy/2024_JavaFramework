package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// 컨트롤러 어노테이션만 목업함
//@WebMvcTest // 가짜 톰캣 ( 가짜 컨테이너 )
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testMockMvc() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name","gildong"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello: gildong"))
		.andDo(MockMvcResultHandlers.print());
	}
}

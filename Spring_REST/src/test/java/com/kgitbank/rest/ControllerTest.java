package com.kgitbank.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class ControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void testSetup() {
		//web.xml 을 여기다 넣어주면 가짜 객체를 만들어주겠다는것
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void homeTest(){
		
		/*
			mockMvc : 테스트를 진행하기 위해 생성한 Spring MVC
			perform(requestBuilder) : 생성한 mocvMvc에 요청을 보내보는 메서드
			RequestBuilders: RequestBuilder를 생성하는 팩토리 클래스
			andReturn(): perform()을 통해 실행된 해당 컨트롤러의 결과를 꺼낸다 
						 해당 결과에서 원하는 값들에 접근할 수 있다.
		*/
		
		try {
			String resultPage = mockMvc.perform(
					MockMvcRequestBuilders.get("/normal/home")
					).andReturn().getModelAndView().getViewName();
		
			assertEquals("/home", resultPage);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void homeModelTest(){
		try {
			Map<String, Object> attributes = mockMvc.perform(
					MockMvcRequestBuilders.get("/normal/home")
					).andReturn().getModelAndView().getModel();
//			이 값들이 나오기를 기대
//			model.addAttribute(123);
//			model.addAttribute("abc");
//			model.addAttribute(123.1234);
			assertEquals("abc", attributes.get("string"));
			assertEquals(123, attributes.get("integer"));
			assertEquals(123.1234, attributes.get("double"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void restTest() throws Exception{
		ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/sample/getMap"));
		action.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		
	}
}










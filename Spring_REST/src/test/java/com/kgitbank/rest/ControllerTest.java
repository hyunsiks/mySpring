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
		//web.xml �� ����� �־��ָ� ��¥ ��ü�� ������ְڴٴ°�
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void homeTest(){
		
		/*
			mockMvc : �׽�Ʈ�� �����ϱ� ���� ������ Spring MVC
			perform(requestBuilder) : ������ mocvMvc�� ��û�� �������� �޼���
			RequestBuilders: RequestBuilder�� �����ϴ� ���丮 Ŭ����
			andReturn(): perform()�� ���� ����� �ش� ��Ʈ�ѷ��� ����� ������ 
						 �ش� ������� ���ϴ� ���鿡 ������ �� �ִ�.
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
//			�� ������ �����⸦ ���
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










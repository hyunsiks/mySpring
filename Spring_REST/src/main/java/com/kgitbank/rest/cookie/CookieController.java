package com.kgitbank.rest.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/cookie")
@Controller
public class CookieController {

	@GetMapping("/login")
	public String login(Model model, String id, String password , HttpSession session, HttpServletResponse response) {
		if(id.equals("abcd") && password.equals("1234")) {
			
//			session.setAttribute("login", true);
			
			Cookie cookie1 = new Cookie("login", "1");
			Cookie cookie2 = new Cookie("id", "abcd");
			
			cookie1.setMaxAge(5);
			cookie1.setHttpOnly(true);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			model.addAttribute("login", true);
		}else {
			//�α��� ���н� ��Ű �� �����ϱ�
			response.addCookie(new Cookie("login", "0"));
			
			//�α��� ���н� ��Ű �����ϱ�(�����ϰ� ���� ��Ű�� ������ 0���� �����Ѵ�)
			Cookie cookie = new Cookie("id", "");
			cookie.setMaxAge(0);

			response.addCookie(cookie);
			
			model.addAttribute("login", false); //jsp���� ��Ʈ����Ʈ ����
//			session.setAttribute("login", false); //������ ���������� �Ǿ��
			log.info("�α��� ����");
		}
		
		return "/cookie/login";
	}
	
	@GetMapping("/read-all-cookies")
	public String readAllCookies(HttpServletRequest request) {
		
		//1. JSP ����� ��Ű ������ (HttpServletRequest�� ���� �迭�� �������ۿ� ����. ����ϱ����)
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {				
				log.info("name: " + cookie.getName());
				log.info("value: " + cookie.getValue());
			}
		}
		
		//2. SPRING ����� ��Ű ������
		
		return "/cookie/check";
	}
	
	@GetMapping("/check")
	public void check(
			@CookieValue(value = "id", defaultValue ="��ȸ��") String id,
			@CookieValue(value = "login", defaultValue ="0") String login,
			Model model
			) {
		model.addAttribute("id", id);
		model.addAttribute("login", login);
	}
}















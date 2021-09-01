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
			//로그인 실패시 쿠키 값 수정하기
			response.addCookie(new Cookie("login", "0"));
			
			//로그인 실패시 쿠키 삭제하기(삭제하고 싶은 쿠키의 수명을 0으로 설정한다)
			Cookie cookie = new Cookie("id", "");
			cookie.setMaxAge(0);

			response.addCookie(cookie);
			
			model.addAttribute("login", false); //jsp가서 어트리뷰트 끝남
//			session.setAttribute("login", false); //세션이 끝날때까지 실어둠
			log.info("로그인 실패");
		}
		
		return "/cookie/login";
	}
	
	@GetMapping("/read-all-cookies")
	public String readAllCookies(HttpServletRequest request) {
		
		//1. JSP 방식의 쿠키 꺼내기 (HttpServletRequest를 통한 배열로 꺼낼수밖에 없다. 사용하기불편)
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {				
				log.info("name: " + cookie.getName());
				log.info("value: " + cookie.getValue());
			}
		}
		
		//2. SPRING 방식의 쿠키 꺼내기
		
		return "/cookie/check";
	}
	
	@GetMapping("/check")
	public void check(
			@CookieValue(value = "id", defaultValue ="비회원") String id,
			@CookieValue(value = "login", defaultValue ="0") String login,
			Model model
			) {
		model.addAttribute("id", id);
		model.addAttribute("login", login);
	}
}















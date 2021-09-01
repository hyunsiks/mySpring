package com.hshome.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class indexController {

	@RequestMapping("/index")
	public String startIndex() {
		
		System.out.println("¿Ô´Ù¿ä");
		
		return "/index";
		
	}
}

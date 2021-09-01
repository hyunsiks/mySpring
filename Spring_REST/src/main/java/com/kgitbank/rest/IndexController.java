package com.kgitbank.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/main")
public class IndexController {

	@GetMapping("/index")
	public String getIndex() {	
		return "/index";
	}
}

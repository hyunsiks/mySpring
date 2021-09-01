package com.kgitbank.dbpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kgitbank.model.Menu;
import com.kgitbank.service.MenuService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MenuAdminController {

	@Autowired
	MenuService menu_service;
	
	@GetMapping("/menu/")
	public String main() {
		
		return "CRUD";
	}
	
	@GetMapping("/menu/add")
	public void addView() {
		
	}
	
	@PostMapping("/menu/add")
	public String addService(Menu m) {
		
//		log.info("메뉴이름: " + m.getName());
//		log.info("메뉴가격: " + m.getPrice());
//		log.info("카테고리: " + m.getCategory());
	
		//원래 새로운 메뉴를 추가할 떄 해야할 작업들을 처리해야 한다.
		//ex) 동일한 이름의 메뉴가 있는지 체크, 메뉴 이름이 형식에 맞는지 체크 등
		
		menu_service.addMenu(m);
		
//		menu_mapper.newMenu(m);
	
		//여기서는 어트리뷰트에 실어서 다음페이지로 안내하고
		//view로 데이터를 보내는 작업만 하는것이 바람직하다
		
		return "redirect:/menu/";
	}
}

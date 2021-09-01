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
		
//		log.info("�޴��̸�: " + m.getName());
//		log.info("�޴�����: " + m.getPrice());
//		log.info("ī�װ�: " + m.getCategory());
	
		//���� ���ο� �޴��� �߰��� �� �ؾ��� �۾����� ó���ؾ� �Ѵ�.
		//ex) ������ �̸��� �޴��� �ִ��� üũ, �޴� �̸��� ���Ŀ� �´��� üũ ��
		
		menu_service.addMenu(m);
		
//		menu_mapper.newMenu(m);
	
		//���⼭�� ��Ʈ����Ʈ�� �Ǿ ������������ �ȳ��ϰ�
		//view�� �����͸� ������ �۾��� �ϴ°��� �ٶ����ϴ�
		
		return "redirect:/menu/";
	}
}

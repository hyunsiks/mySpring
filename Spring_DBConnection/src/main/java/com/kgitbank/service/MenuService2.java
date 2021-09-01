package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.MenuMapper;
import com.kgitbank.model.Menu;

//@Service
public class MenuService2 implements MenuService {
	
	@Autowired
	MenuMapper menu_mapper;
	
	public boolean addNewMenu(Menu m) {
		
//		log.info("메뉴이름: " + m.getName());
//		log.info("메뉴가격: " + m.getPrice());
//		log.info("카테고리: " + m.getCategory());
	
		//원래 새로운 메뉴를 추가할 떄 해야할 작업들을 처리해야 한다.
		//ex) 동일한 이름의 메뉴가 있는지 체크, 메뉴 이름이 형식에 맞는지 체크 등
		
		return menu_mapper.newMenu(m) > 0;
		
		
	}

	@Override
	public boolean addMenu(Menu m) {
		// TODO Auto-generated method stub
		return false;
	}
}

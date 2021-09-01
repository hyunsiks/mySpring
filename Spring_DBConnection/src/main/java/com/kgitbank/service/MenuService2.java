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
		
//		log.info("�޴��̸�: " + m.getName());
//		log.info("�޴�����: " + m.getPrice());
//		log.info("ī�װ�: " + m.getCategory());
	
		//���� ���ο� �޴��� �߰��� �� �ؾ��� �۾����� ó���ؾ� �Ѵ�.
		//ex) ������ �̸��� �޴��� �ִ��� üũ, �޴� �̸��� ���Ŀ� �´��� üũ ��
		
		return menu_mapper.newMenu(m) > 0;
		
		
	}

	@Override
	public boolean addMenu(Menu m) {
		// TODO Auto-generated method stub
		return false;
	}
}

package com.kgitbank.model;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import jdk.internal.org.jline.utils.Log;

public class LombokTest {

	//�� Ŭ������ �α��� ����ϴ� �ΰŸ� �����Ѵ�(import�� �ΰŸ� ��ã�ƾ��� import org.apache.log4j)
	Logger log = Logger.getLogger(LombokTest.class);
//	Logger logger = Logger.getLogger(this.getClass());
	
	
	@Test
	public void test() {
		
		Employee emp = new Employee(10,"Smith","ASMITH");
		log.fatal(emp);
		log.error(emp);
		log.warn(emp);
		log.info(emp);
		log.debug(emp);
		log.trace(emp);
//		System.out.println(emp);
		assertEquals("Getter�� ���� �� ����", 0, emp.getDepartment_id());
	}
}

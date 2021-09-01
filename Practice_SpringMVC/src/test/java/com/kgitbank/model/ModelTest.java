package com.kgitbank.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelTest {

	
	@Autowired
	private Market market;
	
	@Test
	public void simpleTest() {
	
		int a = 10;
		int b = 20;
		
		assertEquals(30, a+b);
	}
	
//	@Test
//	public void di_test() {
//		
//	}
}

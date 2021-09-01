package com.kgitbank.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.model.Employee;
import com.kgitbank.model.Stock;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class StockTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private StockMapper StockMapper;
	
	
	@Test
	public void getListTest() {
		List<Stock> stocks = StockMapper.getStockLi();
		
		if(stocks.size() == 0) {
			fail("¾È²¨³»Á³´Ù ÀÌ´®¾Æ");
		}
		
		for(Stock stock : stocks) {
			System.out.println(stock);
		}
	}
	
	@Test
	public void updateListTest() {
		
	}
	
//	@Test
//	public void getListTest2() {
//		List<Stock> stocks = StockMapper.getStockList();
//		
//		if(stocks.size() == 0) {
//			fail("¾È²¨³»Á³´Ù ÀÌ´®¾Æ");
//		}
//		
//		for(Stock stock : stocks) {
//			System.out.println(stock);
//		}
//	}
	

}

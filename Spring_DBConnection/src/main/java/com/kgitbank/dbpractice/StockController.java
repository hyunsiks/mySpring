package com.kgitbank.dbpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgitbank.mapper.StockMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.model.Stock;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private StockMapper StockMapper;
	
	
	
	@RequestMapping("/start")
	public String dispatch() {
		System.out.println("지나왔다");
		return "/CRUD";
	}
	
	@RequestMapping("/update")
	public String update() {
		
		Stock e = new Stock(
				"samsung",80000,20);
		
		int row = StockMapper.insertStock(e);
		
		System.out.println("update지나옴");
		return "/CRUD";
	}
	
	@RequestMapping("/select")
	public String select() {
		
		List<Stock> stocks = StockMapper.getStockLi();

		for(Stock stock : stocks) {
			System.out.println(stock);
		}
		
		
		System.out.println("지나왔다");
		return "/CRUD";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		
		Stock e = new Stock(
				"samsung",80000,20);
		
		int row = StockMapper.deleteStock(e);
		

		System.out.println("delete지나왔다");
		return "/CRUD";
	}

	@RequestMapping("/change")
	public String change() {
		
		Stock e = new Stock(
				"samsung",80000,20);
//		Stock change = new Stock("LG", 130000, 20);
		
		int row = StockMapper.changeStock(e);
		
		System.out.println("change지나옴");
		return "/CRUD";
	}

}

package com.kgitbank.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.model.FruitVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/sample")
public class RestSampleController {
	
	@GetMapping(value="/getstr", produces="text/plain; charset=UTF-8")
	public String getString() {	
		return "�ȳ��ϼ��� REST��Ʈ�ѷ� �Դϴ�.";
	}
	
	@GetMapping(value="/getstr2", produces=MediaType.TEXT_PLAIN_VALUE +"; charset=UTF-8")
	public String getString2() {
		return "<h3>Hello Rest! ���</h3>";
	}
	
	@GetMapping(value="/getstr3", produces=MediaType.TEXT_HTML_VALUE +"; charset=UTF-8")
	public String getString3() {
		return "<h3>Hello Rest! ���</h3>";
	}
	
	@GetMapping(value="/getSample", produces=MediaType.APPLICATION_JSON_VALUE)
	public FruitVO getSamepleObject() {
		return new FruitVO();
	}
	
	@GetMapping(value="/getSample2", produces=MediaType.APPLICATION_XML_VALUE)
	public FruitVO getSamepleObject2() {
		return new FruitVO();
	}
	
	@GetMapping(value="/getSampleList")
	public FruitVO getSampleList() {
		List<FruitVO> list = new ArrayList<>();
		
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		
		return new FruitVO();
	}
	
	@GetMapping(value="/getSampleMap", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, FruitVO> getSampleMap(){
		Map<String, FruitVO> map = new HashMap<>();
		
		map.put("APPLE1", new FruitVO());
		map.put("APPLE2", new FruitVO());
		map.put("APPLE3", new FruitVO());
		map.put("APPLE4", new FruitVO());
		
		return map;
	}

	@GetMapping(value="/getRespEntity")
	public ResponseEntity<FruitVO> getRespEntity(){
		
		//ResponseEntity�� ���α׷��Ӱ� ���� Http������ �ڼ��� ������ �� �ִ�.
		//������ �޴� ������ status �ڵ带 Ȱ���� �� �ִ�
		ResponseEntity<FruitVO> result = null;
		
		result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FruitVO());
		
		return result;
	}
	
	@GetMapping(value="/path/{year}/{month}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String pathTest(
			@PathVariable("year") int year,
			@PathVariable("month") int month		
			) {
		
		return "Hello! you putted " + year + "/" + month + " in your uri path";
	}
	
	/*
		@RequestBody
		
		 - ��Ʈ�ѷ����� JSON �����͸� �޾ƾ� �� �� ����ϴ� ������̼�
	 	 - ��û�� body�� �Ƿ��ִ� JSON�����͸� �˾Ƽ� ��ȯ���ش�
	 
		@PostMapping�� �޼����� ������ ���?
		
		 - ũ���� Rest Client Ȯ�� �ñ׷� �� ������ ��� ���� ����ؼ� test
	 */
	
	@PostMapping(value="/fruit", produces=MediaType.TEXT_PLAIN_VALUE)
	public String convertJsonFruit(@RequestBody FruitVO fruit) {
		
		return "Your fruit is " + fruit;
	}
}














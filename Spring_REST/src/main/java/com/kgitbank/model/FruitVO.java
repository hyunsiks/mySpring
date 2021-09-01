package com.kgitbank.model;

import lombok.Data;

@Data
public class FruitVO {

	String name;
	int price;
	int calorie;
	
	public FruitVO() {
		// TODO Auto-generated constructor stub
		name = "»ç°ú";
		price = 1500;
		calorie = 300;
	}
}

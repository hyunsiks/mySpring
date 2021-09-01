package com.kgitbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor //��� �÷��� �� �����ڸ� ����� ������
@RequiredArgsConstructor //nonNull�� �� �����ڸ� ����� ������
@Data
public class Stock {

//	STOCK_ID       NOT NULL NUMBER(6)    
//	STOCK_NAME              VARCHAR2(40) 
//	STOCK_PRICE             NUMBER(15)   
//	STOCK_HOLDINGS          NUMBER(15) 
	private Integer stock_id;
	@NonNull
	private String stock_name;
	@NonNull
	private Integer stock_price;
	@NonNull
	private Integer stock_holdings;
}

package com.kgitbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor //모든 컬럼이 들어간 생성자를 만들기 위함임
@RequiredArgsConstructor //nonNull만 들어간 생성자를 만들기 위함임
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

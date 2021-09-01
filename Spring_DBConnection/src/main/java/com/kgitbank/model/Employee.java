package com.kgitbank.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor //모든 컬럼이 들어간 생성자를 만들기 위함임
@RequiredArgsConstructor //nonNull만 들어간 생성자를 만들기 위함임
@Data
public class Employee {

//	EMPLOYEE_ID    NOT NULL NUMBER(6)    
//	FIRST_NAME              VARCHAR2(20) 
//	LAST_NAME      NOT NULL VARCHAR2(25) 
//	EMAIL          NOT NULL VARCHAR2(25) 
//	PHONE_NUMBER            VARCHAR2(20) 
//	HIRE_DATE      NOT NULL DATE         
//	JOB_ID         NOT NULL VARCHAR2(10) 
//	SALARY                  NUMBER(8,2)  
//	COMMISSION_PCT          NUMBER(2,2)  
//	MANAGER_ID              NUMBER(6)    
//	DEPARTMENT_ID           NUMBER(4)
	
	//DB 컬럼과 스펠링이 똑같아야함
	private Integer employee_id;
	private String first_name;
	@NonNull
	private String last_name;
	@NonNull
	private String email;
	private String phone_number;
	@NonNull
	private Date hire_date;
	@NonNull
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	private Integer department_id;
}

package com.kgitbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
public class Department {
	
//	DEPARTMENT_ID   NOT NULL NUMBER(4)    
//	DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
//	MANAGER_ID               NUMBER(6)    
//	LOCATION_ID              NUMBER(4) 
	
	@NonNull
	private int department_id;
	@NonNull
	private String department_name;
	private int manager_id;
	private int location_id;
}

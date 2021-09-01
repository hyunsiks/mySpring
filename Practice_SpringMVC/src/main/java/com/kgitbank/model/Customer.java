package com.kgitbank.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Customer {
	String name;
	String phoneNumber;
	String birthday;
}

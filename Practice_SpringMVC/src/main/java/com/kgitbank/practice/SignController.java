package com.kgitbank.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgitbank.model.Customer;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SignController {

	@Autowired
	ServletContext application;
	
	@RequestMapping("/sign/up")
	public String dispatch() {
	
		return "/user/join";
	}
	@RequestMapping("/sign/success")
	public String successSignUp() {
		return "user/join";
	}
	
	@PostMapping(value ="/sign/file")
	public String redirect(Customer customer) {
		
		
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		String name = customer.getName();
		String phoneNum = customer.getPhoneNumber();
		String birthday = customer.getBirthday();
		
		
		if(!(phoneNum.length() == 10 || phoneNum.length() == 11) || phoneNum.charAt(0) != '0' || phoneNum.charAt(1) != '1') {
			return "user/signFailed";
		}else {
			for(int i =0; i < phoneNum.length(); i++) {
				if(phoneNum.charAt(i) < '0' && phoneNum.charAt(i) > '9') {
					return "user/signFailed";
				}
			}
		}
		
//		if(birthday.length() != 8) {
//			return "user/signFailed";			
//		}else {
//			for(int i =0; i < birthday.length(); i++) {
//				if(birthday.charAt(i) < '0' && birthday.charAt(i) > '9') {
//					return "user/signFailed";
//				}
//			}
//		}
//		System.out.println(""application.getRealPath("./note"));
		
//		File fi = new File(application.getRealPath("./" + "WEB-INF\\views\\data\\customer.txt"));
		File fi = new File("C:\\Users\\ASUS\\Documents\\mshyunsik\\JAVA\\spring-workspace\\Practice_SpringMVC\\note\\log\\cutomerInfo.txt");
		try {
			FileWriter fw = new FileWriter(fi, true);
			FileReader fr = new FileReader(fi);
		    BufferedWriter writer = new BufferedWriter(fw);
		    BufferedReader reader = new BufferedReader(fr);
		    String line = null; 
		    ArrayList<String> arr = new ArrayList<>();
		    ArrayList<String> arr2 = new ArrayList<>();
		    while ((line = reader.readLine()) != null){
		    
//		    	 System.out.println("확인 : " + line.substring(5,line.indexOf("/")));
		    	 arr.add(line.substring(5,line.indexOf("/")));
		    }
		    for(int i=0; i < arr.size(); i++) {
		    
//		    	System.out.println("확인 : " + arr.get(i));
		    	if(name.equals(arr.get(i))) {
		    		int count = 0;
		    		boolean judge = true;
		    		while(judge) {
		    			count++;
		    			System.out.println(count);
		    			for(int j=0; j < arr.size(); j++) {
//		    	
		    				
		    				System.out.println("namecount" + name + (count +""));
		    				System.out.println("arr" + arr.get(j));
		    				if(((name + (count +"")).equals(arr.get(j)))){
//		    					System.out.println("들어옴" + count);
		    					continue;
		    				}
//		    				System.out.println("네임 : " + name);
		    				name = name + (count +"");
		    				judge = false;
		    				break;
		    			}
		    			
		    		}
		    	}
		    }
			log.info("name : " +name);
			log.info("PhoneNum : " + phoneNum);
			log.info("Birthday : " + birthday);
		    String str = "이름 : " + name + "/전화번호 : " + phoneNum + "/생년월일 : " + birthday;
		    
		    writer.newLine();
		    writer.append(str);
		    writer.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.println("등록완료");
		return "/user/signSuccess";
	}
}

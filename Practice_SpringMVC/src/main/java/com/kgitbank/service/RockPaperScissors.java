package com.kgitbank.service;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

//스프링의 root-context에 컴포넌트로서 등록할 것
@Getter
@Component
@ToString
public class RockPaperScissors {

	// 가위, 바위, 보 중 하나를 입력받으면 승/무/패 겨로가가 리턴되는 메서드를 하나작성
	
	private String[] result = {"승", "무"	, "패"};
	public String versus(String user) {
		
		return result[(int)(Math.random()*result.length)];
	}
	
	
	
	
	
	
	
//	int myValue;
//	String result ="";
//	
//
//	
//	public boolean result(int myValue) {
//		//1바위 2가위 3보
//		
//		
//		int random = (int) (Math.random()*3 + 1);
//		switch(myValue){
//		case 1 :
//			if(random == 1) {
//				result = "draw";
//			}else if(random == 2) {
//				result = "win";
//			}else if(random == 3) {
//				result = "lose";
//			}
//			break;
//		case 2 :
//			if(random == 1) {
//				result = "lose";
//			}else if(random == 2) {
//				result = "draw";
//			}else if(random == 3) {
//				result = "win";
//			}
//			break;
//		case 3 :
//			if(random == 1) {
//				result = "win";
//			}else if(random == 2) {
//				result = "lose";
//			}else if(random == 3) {
//				result = "draw";
//			}
//			break;
//		}
//		if(result.equals("win") || result.equals("draw") || result.equals("lose")) {
//			
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
//	//JUnit 테스트로 메서드를 20회 테스트하고 파일에 결과에대한 로그를 남겨보세요
//	public String resultValue(int myValue) {
//		//1바위 2가위 3보
//		
//		
//		int random = (int) (Math.random()*3 + 1);
//		switch(myValue){
//		case 1 :
//			if(random == 1) {
//				result = "draw";
//			}else if(random == 2) {
//				result = "win";
//			}else if(random == 3) {
//				result = "lose";
//			}
//			break;
//		case 2 :
//			if(random == 1) {
//				result = "lose";
//			}else if(random == 2) {
//				result = "draw";
//			}else if(random == 3) {
//				result = "win";
//			}
//			break;
//		case 3 :
//			if(random == 1) {
//				result = "win";
//			}else if(random == 2) {
//				result = "lose";
//			}else if(random == 3) {
//				result = "draw";
//			}
//			break;
//		}
//	
//		return result;
//		
//	}
}

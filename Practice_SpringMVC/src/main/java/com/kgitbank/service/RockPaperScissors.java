package com.kgitbank.service;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

//�������� root-context�� ������Ʈ�μ� ����� ��
@Getter
@Component
@ToString
public class RockPaperScissors {

	// ����, ����, �� �� �ϳ��� �Է¹����� ��/��/�� �ܷΰ��� ���ϵǴ� �޼��带 �ϳ��ۼ�
	
	private String[] result = {"��", "��"	, "��"};
	public String versus(String user) {
		
		return result[(int)(Math.random()*result.length)];
	}
	
	
	
	
	
	
	
//	int myValue;
//	String result ="";
//	
//
//	
//	public boolean result(int myValue) {
//		//1���� 2���� 3��
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
//	//JUnit �׽�Ʈ�� �޼��带 20ȸ �׽�Ʈ�ϰ� ���Ͽ� ��������� �α׸� ���ܺ�����
//	public String resultValue(int myValue) {
//		//1���� 2���� 3��
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

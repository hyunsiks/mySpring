package com.kgitbank.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class QuizTest {

	@Autowired
	Prime prime;
	
	public void check1() {
		//1이 소수가 아니라고 나와야 테스트 통과하는것(아니어야 통과하는것 assertFalse)
		assertFalse("1이 소수인지 테스트중 : ",prime.isPrime(1));
	}
	
	@Test
	@Ignore
	public void check3() {
		
		//3이 소수라고 판별되야 통과하는 테스트(assertTrue)
		assertTrue("3이 소수인지 테스트중 : ",prime.isPrime(3));
	}
	
	//원하는 예외가 발생해야 통과하는 테스트
	@Test(expected =ClassNotFoundException.class)
	public void expectedTest() throws ClassNotFoundException {
		prime.veryAwesomeFunction(123);
	}
	
	//시간 제한 안에 성공해야 하는 테스트
	@Test(timeout = 100)
	public void timeoutTest() {
		for(int i = 0; i < 1000000; i++) {
			System.out.println(i + "번째 출력");
		}
	}
	
	
	
	
	
}

package com.kgitbank.quiz;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.model.Employee;
import com.kgitbank.model.LombokTest;
import com.kgitbank.service.RockPaperScissors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class RockPaperScissorsTest {

	@Autowired
	RockPaperScissors RockPaperScissors;
	
	Logger log = Logger.getLogger(RockPaperScissors.class);

	
	
	
//	@Test
//	public void check1() {
//		
//		for(int i = 0; i < 20; i++) {
//			assertTrue(RockPaperScissors.result((int)(Math.random()*3 + 1)));			
//		}
//		
//		for(int i = 0; i < 20; i++) {
//			int myValue = (int)(Math.random()*3 +1);
//			log.fatal(RockPaperScissors.resultValue(myValue));
//			log.error(RockPaperScissors.resultValue(myValue));
//			log.warn(RockPaperScissors.resultValue(myValue));
//			log.info(RockPaperScissors.resultValue(myValue));
//			log.debug(RockPaperScissors.resultValue(myValue));
//			log.trace(RockPaperScissors.resultValue(myValue));
//		}
//	}
	
}

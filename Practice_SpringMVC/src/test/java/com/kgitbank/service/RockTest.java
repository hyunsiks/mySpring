package com.kgitbank.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//rootContext林家茫酒啊具达
public class RockTest {

	@Autowired
	RockPaperScissors game;
	
	@Test
	public void Rock() {
		for(int i =0; i < 20; i++) {
			log.info(game.versus("林冈"));
		}
	}
}

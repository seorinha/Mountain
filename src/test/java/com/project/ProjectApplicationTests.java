package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest  //spring boot를 기동시킨다 
class ProjectApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void contextLoads() {
	}

	//@Test
	void 더하기테스트() {
		logger.debug("###### 더하기 테스트 수행 #####");
		int a = 10;
		int b = 20;
		assertEquals(30, a + b);
	}
	
	//@Autowired
	//UserBO userBO;
	
	//@Transactional //rollback시켜주는 어노테이션 - 테스트 해보고 다시 원래대로 되돌려준다
	//@Test
//	void 유저추가테스트() {
//		userBO.addUser("test", "aaaa", "test", "testest");
//	}
	
}

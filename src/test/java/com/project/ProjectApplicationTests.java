package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

@SpringBootTest  //spring boot를 기동시킨다 
class ProjectApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test //비어있는지 체크 
	void 검사_테스트() {
		//String str = null;
		String str = "";
		if (ObjectUtils.isEmpty(str)) { //null or ""
			logger.info("####str은 null또는 비어있다.####");
		}
		
		//List<Integer> list = null;
		List<Integer> list = new ArrayList<>();
		if (ObjectUtils.isEmpty(list)) { //null or []
			logger.info("$$$ list는 null이거나 비어있다");
		}
	}
	
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

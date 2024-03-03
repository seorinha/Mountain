package com.project.user.bo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserBOTest {

	@Autowired
	UserBO userBO;
	
	@Transactional //rollback시켜주는 어노테이션 - 테스트 해보고 다시 원래대로 되돌려준다
	@Test
	void 유저추가테스트() {
		userBO.addUser("test", "aaaa", "name", "test@test");
	}

}

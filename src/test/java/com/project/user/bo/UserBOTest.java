package com.project.user.bo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserBOTest {

	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserBO userBO;

	@Test
    void 로그인_성공_테스트() {
        // Given
        String loginId = "exampleId";
        String password = "examplePassword";
        
        // Mock 객체 생성
        UserEntity mockUserEntity = mock(UserEntity.class); 
        when(mockUserEntity.getLoginId()).thenReturn(loginId); // 목 객체의 로그인 아이디 설정
        when(mockUserEntity.getPassword()).thenReturn(password); // 목 객체의 비밀번호 설정
        
        // 목 객체의 동작 정의
        when(userRepository.findByLoginIdAndPassword(loginId, password)).thenReturn(mockUserEntity); 

        // When
        UserEntity userEntity = userBO.getUserEntityByLoginIdPassword(loginId, password);


	     // Then
	        Assertions.assertNotNull(userEntity); 
	        Assertions.assertEquals(loginId, userEntity.getLoginId()); 
	        Assertions.assertEquals(password, userEntity.getPassword()); 
	  }

    @Test
    void 로그인_실패_테스트() {
        // Given
        String loginId = "exampleId";
        String password = "wrongPassword"; // 틀린 비밀번호

        // When
        UserEntity userEntity = userBO.getUserEntityByLoginIdPassword(loginId, password);

        // Then
        Assertions.assertNull(userEntity); // 로그인에 실패했으므로 사용자 엔터티가 null이어야 함
    }
	
//	@Test
//    void 아이디중복확인테스트_중복되지않는경우() {
//        // Given
//        String loginId = "uniqueId";
//
//        // When
//        UserEntity userEntity = userBO.getUserEntityByLoginId(loginId);
//
//        // Then
//        Assertions.assertNull(userEntity);
//    }
//
//    @Test
//    void 아이디중복확인테스트_중복되는경우() {
//        // Given
//        String loginId = "existingId";
//
//        // When
//        UserEntity userEntity = userBO.getUserEntityByLoginId(loginId);
//
//        // Then
//        Assertions.assertNull(userEntity);
//      
//    }
	
//	@Test
//	void 유저추가테스트() {
//		 // Given
//        String loginId = "test";
//        String password = "aaaa";
//        String name = "name";
//        String email = "test@test";
//
//        // When
//        Integer userId = userBO.addUser(loginId, password, name, email);
//
//        // Then
//        Assertions.assertNotNull(userId);
//	}

}

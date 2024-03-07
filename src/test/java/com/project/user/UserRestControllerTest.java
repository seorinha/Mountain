package com.project.user;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@AutoConfigureMockMvc
@SpringBootTest
class UserRestControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @Mock
    private UserBO userBO;

    @InjectMocks
    private UserRestController userRestController;
    
    
//    @Transactional
//    @Test
//    void 회원가입_테스트() throws Exception {
//        // Given
//        String loginId = "exampleId";
//        String password = "examplePassword";
//        String name = "Example User";
//        String email = "example@example.com";
//
//        String hashedPassword = PasswordEncoder.encode(password);
//        Integer userId = 1; // 예시로 사용자 ID를 지정합니다.
//
//        // Mocking the userBO response
//        when(userBO.addUser(anyString(), anyString(), anyString(), anyString())).thenReturn(userId);
//
//        // When & Then
//        mockMvc.perform(post("/user/sign-up")
//                .param("loginId", loginId)
//                .param("password", password)
//                .param("name", name)
//                .param("email", email))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code").value(200))
//                .andExpect(jsonPath("$.result").value("성공"));
//    }
//
//    @Transactional
//    @Test
//    void 회원가입_실패_테스트() throws Exception {
//    	 // Given
//        String loginId = "testUser";
//        String password = "examplePassword";
//        String email = "example@example.com";
//        String name = "";
//
//        // When & Then
//        mockMvc.perform(post("/user/sign-up")
//                .param("loginId", loginId)
//                .param("password", password)
//                .param("email", email)
//                .param("name", name))
//        		.andExpect(status().isOk())
//                .andExpect(jsonPath("$.code").value(400))
//                .andExpect(jsonPath("$.errorMessage").value("이름을 입력하세요"))
//                .andExpect(jsonPath("$.result").doesNotExist()); 
//    }
    
    
//    @Test
//    void 아이디중복확인테스트_중복되지않는경우() throws Exception {
//        // Given
//        String loginId = "exampleId";
//
//        // Mocking the userBO response
//        when(userBO.getUserEntityByLoginId(anyString())).thenReturn(null);
//
//        // When
//        Map<String, Object> result = userRestController.isDuplicatedId(loginId);
//
//        // Then
//        assertEquals(200, result.get("code"));
//        assertFalse((boolean) result.get("isDuplicated"));
//    }
//
//    @Test
//    void 아이디중복확인테스트_중복되는경우() throws Exception {
//        // Given
//        String loginId = "exampleId";
//        UserEntity mockUserEntity = UserEntity.builder()
//                .id(1)
//                .name("Example User")
//                .loginId(loginId)
//                .build();
//
//        // Mocking the userBO response
//        when(userBO.getUserEntityByLoginId(anyString())).thenReturn(mockUserEntity);
//
//        // When
//        Map<String, Object> result = userRestController.isDuplicatedId(loginId);
//
//        // Then
//        assertEquals(200, result.get("code"));
//        assertTrue((boolean) result.get("isDuplicated"));
//    }
    

    
    
   
    


    

}

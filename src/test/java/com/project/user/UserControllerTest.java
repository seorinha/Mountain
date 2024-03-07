package com.project.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

class UserControllerTest {

//	private UserController userController;
//    private HttpSession session;
//  //  private RedirectAttributes redirectAttributes;
//
//    @BeforeEach
//    void setUp() {
//        userController = new UserController();
//        session = mock(HttpSession.class);
//        //redirectAttributes = mock(RedirectAttributes.class);
//    }
//
//    @Test
//    void signOutTest() {
//        // Given
//        when(session.getAttribute("userId")).thenReturn("testUserId");
//        when(session.getAttribute("userName")).thenReturn("testUserName");
//        when(session.getAttribute("userLoginId")).thenReturn("testUserLoginId");
//
//        // When
//        String result = userController.signOut(session);
//
//        // Then
//        verify(session).removeAttribute("userId");
//        verify(session).removeAttribute("userName");
//        verify(session).removeAttribute("userLoginId");
//        assertEquals("redirect:/user/sign-in-view", result);
//    }
	
//		 @Test
//		    void signInViewTest() {
//		        // Given
//		        UserController userController = new UserController();
//		        Model model = new ConcurrentModel();
//	
//		        // When
//		        String viewName = userController.signInView(model);
//	
//		        // Then
//		        assertEquals("template/layout", viewName);
//		        assertEquals("user/signIn", model.getAttribute("viewName"));
//		    }
//	
//	
//	@Test
//    void signUpViewTest() {
//        // Given
//        UserController userController = new UserController();
//        Model model = new ConcurrentModel();
//
//        // When
//        String viewName = userController.signUpView(model);
//
//        // Then
//        assertEquals("template/layout", viewName);
//        assertEquals("user/signUp", model.getAttribute("viewName"));
//    }
}

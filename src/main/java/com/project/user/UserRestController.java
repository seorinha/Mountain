package com.project.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.common.EncryptUtils;
import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	/**
	 * 아이디 중복확인
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		//db 조회
		UserEntity user = userBO.getUserEntityByLoginId(loginId);
		
		//응답값 만들고 return-> json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		
		if (user == null) {
			//중복 아닐때
			result.put("isDuplicated", false);
		} else {
			//중복일 때
			result.put("isDuplicated", true);
		}
		return result;
		
	}
	
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @return
	 */
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		//password 해싱 - md5알고리즘
		String hashedPassword = EncryptUtils.md5(password);
		
		//db insert
		Integer id = userBO.addUser(loginId, hashedPassword, name, email);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		
		if (id == null) {
			result.put("code", 500);
			result.put("errorMessage", "회원가입에 실패했습니다");
		} else {
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result; 
	}
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @param session
	 * @return
	 */
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		
		//password hashing
		String hasedPassword = EncryptUtils.md5(password);
		
		//db insert
		UserEntity userEntity = userBO.getUserEntityByLoginIdPassword(loginId, hasedPassword);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		if (userEntity != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userEntity.getId());
			session.setAttribute("userName", userEntity.getName());
			session.setAttribute("userLoginId", userEntity.getLoginId());
			
			result.put("code", 200);
			result.put("result", "성공");
		} else { //로그인 불가
			result.put("code", 500);
			result.put("errorMessage", "존재하지 않는 사용자입니다");
		}
		return result;
		
	}
	
}

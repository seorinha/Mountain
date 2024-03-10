package com.project.kakao;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user.PasswordEncoder;
import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@Controller
@RequestMapping("/kakao")
public class KakaoController {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/callback")
	public String kakaoCallback(String code, HttpSession session) { 
		
		//POST 방식으로 key=value 데이터를 요청해야함 (카카오쪽으로)
		//Retrofit2(안드로이드)
		//OkHttp
		//RestTemplate
		
		RestTemplate rt = new RestTemplate();
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "1f9ba236274cc877d8d549827331eb10");
		params.add("redirect_uri", "http://15.165.204.48:8080/kakao/callback");
		params.add("code", code);
		
		//HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params, headers);
		
		//Http요청하기 - Post 방식으로-그리고 response 변수의 응답 받음
		ResponseEntity<String> response = rt.exchange(
			"https://kauth.kakao.com/oauth/token",
			HttpMethod.POST,
			kakaoTokenRequest,
			String.class
		);
		
		//Gson, Json Simple, ObjectMapper 라이브러리 
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		
		try {
			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("카카오 엑세스 토큰: " + oauthToken.getAccess_token());
		
		//토큰을 이용해서 사용자 정보 조회 
		RestTemplate rt2 = new RestTemplate();
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = 
				new HttpEntity<>(headers2);
		
		//Http요청하기 - Post 방식으로-그리고 response 변수의 응답 받음
		ResponseEntity<String> response2 = rt2.exchange(
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.POST,
			kakaoProfileRequest2,
			String.class
		);
		
		//Gson, Json Simple, ObjectMapper 라이브러리 
				ObjectMapper objectMapper2 = new ObjectMapper();
				KakaoProfile kakaoProfile = null;
				
				try {
					kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		
				//user오브젝트 : username, password, 
				System.out.println("카카오 id : " + kakaoProfile.getId());
				System.out.println("카카오 nickname : " + kakaoProfile.getProperties().getNickname());
				
				System.out.println("mount서버 유저네임 : " + kakaoProfile.getProperties().getNickname() + "_" + kakaoProfile.getId());
				String rawPassword = UUID.randomUUID().toString(); //임시 패스워드 만들기
				String encodedPassword = PasswordEncoder.encode(rawPassword);;
 
				System.out.println("mount서버 패스워드 : " + encodedPassword);
				
				UserEntity kakaoUser = UserEntity.builder()
						.loginId(kakaoProfile.getProperties().getNickname())
						.password(encodedPassword)
						.name(kakaoProfile.getProperties().getNickname() + "_" + kakaoProfile.getId())
						.build();
				
				//가입자 혹은 비가입자 체크 해서 처리
				Optional<UserEntity> originUserEntity = userBO.getUserEntityByName(kakaoUser.getName());
				
				if (originUserEntity.isPresent()) { // 이미 가입된 회원인 경우
			        // 해당 회원으로 로그인 처리
					System.out.println("기존 회원입니다-----------------");
			        UserEntity loggedInUser = originUserEntity.get();
			        session.setAttribute("userId", loggedInUser.getId());
			        session.setAttribute("userName", loggedInUser.getName());
			        session.setAttribute("userLoginId", loggedInUser.getLoginId());
			        session.setAttribute("kakaoUserName", kakaoProfile.getProperties().getNickname());

			        // 로그인 성공 메시지 반환
			        return "redirect:/home/home-list-view";
			    } else { // 비가입자인 경우
			        // 회원가입 처리
			        userBO.addKakaoUser(kakaoUser);

			        // 회원가입 완료 메시지 반환
			        return "redirect:/home/home-list-view";
			    }
	}

}
	    

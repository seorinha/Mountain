package com.project.kakao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/kakao")
public class KakaoController {
	
	@ResponseBody
	@GetMapping("/callback")
	public String kakaoCallback(String code) { //data를 리턴해주는 컨트롤러 함수
		
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
		params.add("redirect_uri", "http://localhost:8080/kakao/callback");
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
		
		return "카카오 토큰요청 완료 : 토큰 요청에 대한 응답 :" + response.getBody();
		
	}
	
	
//	Logger logger = LoggerFactory.getLogger(KakaoController.class);
//	
//	private KakaoApi kakaoApi = new KakaoApi();
//	
//	@RequestMapping(value="/oauth", method=RequestMethod.GET)
//	public String kakaoConnect() {
//
//	  StringBuffer url = new StringBuffer();
//	  url.append("https://kauth.kakao.com/oauth/authorize?");
//	  url.append("client_id=" + "1f9ba236274cc877d8d549827331eb10");
//	  url.append("&redirect_uri=http://localhost:8080/home/home-list-view");
//	  url.append("&response_type=code");
//
//	  return "redirect:" + url.toString();
//	 }
//
//	@RequestMapping(value="/callback",produces="application/json",method= {RequestMethod.GET, RequestMethod.POST})
//	 public void kakaoLogin(
//			 @RequestParam("code") String code,
//			 RedirectAttributes ra,
//			 HttpSession session,
//			 HttpServletResponse response,
//			 Model model)throws IOException {
//	  
//	  System.out.print("kakao code:" + code);
//
//	  //토큰 받아오기
//	  JsonNode access_token = kakaoApi.getKakaoAccessToken(code); 
////	  System.out.println(access_token);
//	  
//	  //사용자 정보 요청
//	  JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(access_token.get("access_token"));
//
//      // Get id
//      String member_id = userInfo.get("id").asText();
//
//      String member_name = null;
//     
//      // 유저정보 카카오에서 가져오기 Get properties
//      JsonNode properties = userInfo.path("properties");
//      JsonNode kakao_account = userInfo.path("kakao_account");
//      member_name = properties.path("nickname").asText(); //이름 정보 가져오는 것
//     // email = kakao_account.path("email").asText();
//	  
//	  //return "home";
//      System.out.print("id : " + member_id);    //여기에서 값이 잘 나오는 것 확인 가능함.
//      System.out.print("nickname : " + member_name);
//     // logger.info("email : " + email);
//
//      //return "redirect:/kakao/index";
//      
//	 }
//	
}


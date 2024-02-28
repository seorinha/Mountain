package com.project.kakao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/kakao/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // 카카오와 함께 로그아웃하는 URL
        String logoutUrl = "https://kauth.kakao.com/oauth/logout";

        // 카카오 애플리케이션의 REST API 키
        String clientId = "1f9ba236274cc877d8d549827331eb10";

        // 서비스의 로그아웃 Redirect URI
        String redirectUri = "http://localhost:8080/kakao/logout/redirect";

        // GET 요청에 필요한 파라미터 설정 및 URL 인코딩
        try {
            clientId = URLEncoder.encode(clientId, "UTF-8");
            redirectUri = URLEncoder.encode(redirectUri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // GET 요청에 필요한 파라미터 설정
        String params = "?client_id=" + clientId + "&logout_redirect_uri=" + redirectUri;
        
        // RestTemplate을 이용한 GET 요청
        RestTemplate restTemplate = new RestTemplate();
        
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // 요청 엔티티 생성
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        // RestTemplate을 사용하여 GET 요청 보내기
        restTemplate.exchange(logoutUrl + params, HttpMethod.GET, entity, String.class);
        
        // 카카오에서 제공하는 Redirect URI로 서비스 측으로 리디렉션
        return "redirect:" + logoutUrl + params;
        
	}
	
	// 카카오에서 제공하는 Redirect URI로 요청이 들어왔을 때의 처리
    @RequestMapping(value = "/kakao/logout/redirect", method = RequestMethod.GET)
    public String logoutRedirect(HttpSession session) {
        // 서비스 측에서는 해당 Redirect URI로 요청이 들어왔을 때, 사용자의 세션을 무효화하고 원하는 작업을 수행
        session.invalidate();
        return "redirect:/user/sign-in-view";
    }

}
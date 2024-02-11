package com.project.kakao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KakaoController {
	private Kakao_restapi kakao_restapi=new Kakao_restapi();
	
	    @GetMapping(value="/kakao/oauth")
	    public String kakaoConnect() {

	        StringBuffer url = new StringBuffer();
	        url.append("https://kauth.kakao.com/oauth/authorize?");
	        url.append("client_id=" + "1f9ba236274cc877d8d549827331eb10");
	        url.append("&redirect_uri=http://localhost:8080/kakao/callback");
	        url.append("&response_type=code");

	        return "redirect:" + url.toString();
	    }
	    
	    //callback한 것 받는 코드
	    @RequestMapping(value="/kakao/callback",produces="application/json",method= {RequestMethod.GET, RequestMethod.POST})
	    public void kakaoLogin(
	    		@RequestParam("code")String code, 
	    		RedirectAttributes ra, 
	    		HttpSession session, 
	    		HttpServletResponse response, 
	    		Model model)throws IOException {

	        System.out.println("kakao code:"+code);
	}
}


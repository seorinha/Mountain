package com.project.kakao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KakaoUserInfo {

//	public static JsonNode getKakaoUserInfo(JsonNode accessToken) {
//		   Logger logger = LoggerFactory.getLogger(KakaoUserInfo.class);
//
//		   final String RequestUrl = "https://kapi.kakao.com/v2/user/me";
//		   final HttpClient client = HttpClientBuilder.create().build();
//		   final HttpPost post = new HttpPost(RequestUrl);
//		 
//		   // 요청에 필요한 header에 포함될 내용
//		   post.addHeader("Authorization", "Bearer " + accessToken);  //토큰으로 authorization권한 얻는것.
//		  
//		   JsonNode returnNode = null;
//		 
//		   try {
//		       final HttpResponse response = client.execute(post);
//		       final int responseCode = response.getStatusLine().getStatusCode();
//		       final String msg = response.getStatusLine().getReasonPhrase();
//		       logger.info("\nSending 'POST' request to URL : " + RequestUrl);
//		       System.out.print("Response Code : " + responseCode);
//		       logger.info("Response Code : " + msg);
//
//		       //HttpEntity entity = response.getEntity(); 주석처리 되어있는 이 코드들은 오류가 나는 상황일 때 실행하면 무슨 오류인지 보여줌
//		       //String responseString = EntityUtils.toString(entity, "UTF-8");
//		       //logger.info("responseString----->"+responseString);
//		       
//		       // JSON 형태 반환값 처리
//		       if (responseCode >= 200 && responseCode < 300) {
//		            ObjectMapper mapper = new ObjectMapper();
//		            returnNode = mapper.readTree(response.getEntity().getContent());
//		       } else {
//		            logger.error("Error: HTTP request failed with response code " + responseCode);
//		            // Handle the error response from Kakao
//		       }
//		   } catch (IOException e) {
//		        logger.error("Error: Failed to send HTTP request or read response: " + e.getMessage());
//		        e.printStackTrace();
//		   }
//
//		    return returnNode;
//	}
}

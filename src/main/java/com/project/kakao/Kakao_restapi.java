package com.project.kakao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Kakao_restapi {

	//토큰 가져오기
	public static JsonNode getKakaoAccessToken(String code) { 
		  //System.out.println("restapi클래스"+code);
		        final String RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
		        final List<NameValuePair> postParams = new ArrayList<>();
		 
		        postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		        postParams.add(new BasicNameValuePair("client_id", "1f9ba236274cc877d8d549827331eb10")); // REST API KEY
		        postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/kakao/callback")); // 리다이렉트 URI
		        postParams.add(new BasicNameValuePair("code", code)); // 로그인 과정중 얻은 code 값
		 
		        final HttpClient client = HttpClient.newHttpClient();
		        final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
		                .uri(java.net.URI.create(RequestUrl))
		                .header("Content-Type", "application/x-www-form-urlencoded")
		                .POST(HttpRequest.BodyPublishers.ofString(URLEncodedUtils.format(postParams, "UTF-8")));

		 
		        JsonNode returnNode = null;
		 
		        try {
		        	 final HttpResponse<String> response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
		             final int responseCode = response.statusCode();
		 
		            System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
		            System.out.println("Post parameters : " + postParams);
		            System.out.println("Response Code : " + responseCode);
		 
		            // JSON 형태 반환값 처리
		            ObjectMapper mapper = new ObjectMapper();
		 
		            returnNode = mapper.readTree(response.body());
		 
		        } catch (IOException | InterruptedException e) {
		            e.printStackTrace();
		        }

		        return returnNode;
		    }
	
}

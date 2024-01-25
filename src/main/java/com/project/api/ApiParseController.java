package com.project.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.project.mountain.domain.Mountain;
import com.project.mountain.mapper.MountainMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiParseController {

	@Autowired MountainMapper mountainMapper;

	@GetMapping("/mountain-info")
	 public static void main(String[] args) throws IOException {
	     // url을 만들기 위한 StringBuilder
		 StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B553662/top100FamtListBasiInfoService/getTop100FamtListBasiInfoList"); /*URL*/
	     // open api의 요청 규격에 맞는 파라미터 생성, 발급받은 인증키
		 urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=JVpFRa8p0GbG8tVECHTxUPjTZ4DJAJRZkHcnrC%2Br0zNf%2FijOpKtFEiVqGI8BJIHHcyvZAIo95FHY0zOwCscOOg%3D%3D"); /*Service Key*/
	     urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	     urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	     urlBuilder.append("&" + URLEncoder.encode("frtrlNm","UTF-8") + "=" + URLEncoder.encode("가리산", "UTF-8")); /*조회할 산 이름*/
	     urlBuilder.append("&" + URLEncoder.encode("addrNm","UTF-8") + "=" + URLEncoder.encode("강원도 춘천시 북산면ㆍ동면, 홍천군 두촌면ㆍ화촌면", "UTF-8")); /*주소*/
	     urlBuilder.append("&" + URLEncoder.encode("aslAltide","UTF-8") + "=" + URLEncoder.encode("1051.0", "UTF-8")); /*고도*/
	     urlBuilder.append("&" + URLEncoder.encode("lot","UTF-8") + "=" + URLEncoder.encode("127.956485", "UTF-8")); /*경도*/
	     urlBuilder.append("&" + URLEncoder.encode("lat","UTF-8") + "=" + URLEncoder.encode("37.871353", "UTF-8")); /*위도*/
	     urlBuilder.append("&type=json");/*결과 json 포맷*/
	     // url 객체 생성
	     URL url = new URL(urlBuilder.toString());
	     // 요청 하고자 하는 url과 통신하기 위한 Connection 객체 생성
	     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     // 통신을 위한 메소드
	     conn.setRequestMethod("GET");
	     // 통신을 위한 Content-type
	     conn.setRequestProperty("Content-type", "application/json");
	     // 통신 응답 코드 확인
	     System.out.println("Response code: " + conn.getResponseCode());
	     // 전달받은 데이터를 BufferedReader 객체로 저장
	     BufferedReader rd;
	     if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	     } else {
	         rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	     }
	     // 저장된 데이터를 라인별로 읽어서 StringBuilder 객체로 저장
	     StringBuilder sb = new StringBuilder();
	     String line;
	     while ((line = rd.readLine()) != null) {
	         sb.append(line);
	     }
	     // 객체 해제
	     rd.close();
	     conn.disconnect();
	     // 전달받은 데이터 확인
	     System.out.println(sb.toString());



         JsonParser parser = new JsonParser();
         JsonReader reader = new JsonReader(new StringReader(sb.toString()));
         reader.setLenient(true);
         JsonObject obj = parser.parse(reader).getAsJsonObject();

         JsonObject responseBody = obj.getAsJsonObject("response").getAsJsonObject("body");
         if (responseBody != null) {
             JsonArray items = responseBody.getAsJsonObject("items").getAsJsonArray("item");

             for (JsonElement jsonElement : items) {
                 JsonObject temp = jsonElement.getAsJsonObject();

                 String mtName = temp.has("frtrlNm") ? temp.get("frtrlNm").getAsString() : "";
                 String mtLocation = temp.has("addrNm") ? temp.get("addrNm").getAsString() : "";
                 int mtHeight = temp.has("aslAltide") ? temp.get("aslAltide").getAsInt() : 0;
                 double mtLot = temp.has("mtLot") ? temp.get("mtLot").getAsDouble() : 0;
                 double mtLat = temp.has("mtLat") ? temp.get("mtLat").getAsDouble() : 0;


                 Mountain mountain = Mountain.builder()
                         .mtName(mtName)
                         .mtLocation(mtLocation)
                         .mtHeight(mtHeight)
                         .mtLot(mtLot)
                         .mtLat(mtLat)
                         .build();
                 }
             }
	}
	
	
}
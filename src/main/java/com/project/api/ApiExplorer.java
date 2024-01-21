package com.project.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {

	 public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6440000/Cn100Mt/getList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지당 표출 데이터 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("searchNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색할 산 이름*/
	        urlBuilder.append("&" + URLEncoder.encode("searchArea","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지역코드 (기술문서참조)*/
	        urlBuilder.append("&" + URLEncoder.encode("searchSeason","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*계절코드 (SESS1 = 봄, SESS2 = 여름, SESS3 = 가을, SESS4 = 겨울)*/
	        urlBuilder.append("&" + URLEncoder.encode("searchTheme","UTF-8") + "=" + URLEncoder.encode("TEME1", "UTF-8")); /*테마코드 (기술문서참조)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        //한글 출력을 위해서 utf-8 추가
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
		
	
}

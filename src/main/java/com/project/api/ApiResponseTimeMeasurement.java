package com.project.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiResponseTimeMeasurement {

    public static void main(String[] args) {
        log.info("main 메서드 시작");
        // 측정하려는 API
        String apiUrl = "http://localhost:8080/api/mountain-info";

        try {
            measureApiResponseTime(apiUrl);
        } catch (Exception e) {
            log.error("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void measureApiResponseTime(String apiUrl) throws Exception {
        // API 요청 전에 현재 시간 기록
        long startTime = System.currentTimeMillis();

        // API에 GET 요청 보내기
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // API 응답 코드 확인
        int responseCode = connection.getResponseCode();
        log.info("#### HTTP 상태 코드: " + responseCode);

        // API 응답 내용 읽기 (옵션)
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseContent.append(line);
        }
        reader.close();

        // API 응답 후에 현재 시간 기록
        long endTime = System.currentTimeMillis();

        // 응답 시간 계산 (밀리초 단위)
        long responseTime = endTime - startTime;
        log.info("#### 응답 시간: " + responseTime + " 밀리초");

        // API 응답 내용 출력 (옵션)
        // log.info("응답 내용: " + responseContent.toString());

        // 연결 종료
        connection.disconnect();
    }
	
	
}

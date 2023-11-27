package com.project.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	//업로드 된 이미지가 저장 될 경로(서버의 주소)
	//학원 경로
	//public static final String FILE_UPLOAD_PATH = "";
			
	//집 경로
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\ASUS\\Desktop\\웹개발\\6_project\\workspace\\images/";
	
	//이미지 저장
	//input: userLoginId, file
	//output: web imagePath
	public String saveFile(String loginId, MultipartFile file) {
		
		//폴더 생성
		String directoryName = loginId + "_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성 실패 시 이미지 경로 null로 리턴
			return null;
		}
		
		
		//폴더 안에 파일 업로드:byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes); //진짜 파일 업로드
		} catch (IOException e) {
			e.printStackTrace();
			return null; //이미지 업로드 실패시 null
		}
		
		
		//파일 업로드 성공을 하면 웹 이미지 url path를 return
		//예시 형식 : /images/aaaa_1789456156/sun.png 
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
	
}

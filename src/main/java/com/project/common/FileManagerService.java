package com.project.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	private Logger logger = LoggerFactory.getLogger(FileManagerService.class); 
	
	//업로드 된 이미지가 저장 될 경로(서버의 주소)
	//학원 경로
	public static final String FILE_UPLOAD_PATH = "D:\\하서린\\6_project\\workspace\\images/";
			
	//집 경로
	//public static final String FILE_UPLOAD_PATH = "C:\\Users\\ASUS\\Desktop\\웹개발\\6_project\\workspace\\images/";
	
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
			logger.error("[이미지 업로드] 업로드 실패 loginId:{}, filePath:{}", loginId, filePath);
			return null; //이미지 업로드 실패시 null
		}
		
		
		//파일 업로드 성공을 하면 웹 이미지 url path를 return
		//예시 형식 : /images/aaaa_1789456156/sun.png 
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
	
	//이미지 삭제
	//input:imagePath
	//output:x
	public void deleteFile(String imagePath) { //imagePath : /images/aaaaa_1699005938754/boat.jpg
		// D:\\하서린\\5_spring_project\\MEMO\\workspace\\images/aaaaa_1699005938754/boat.jpg
		//주소에 겹치는 /images/  를 제거해야한다
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));
		if (Files.exists(path)) { //이미지가 존재하는가?
			//이미지 삭제
			try {
				Files.delete(path);
			} catch (IOException e) {
				logger.error("[이미지 삭제] 파일 삭제 실패. imagePath:{}", imagePath);
				return;
			}
				
				
			//폴더(디렉토리) 삭제
			path = path.getParent(); 
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.error("[이미지 삭제] 폴더 삭제 실패. imagePath:{}", imagePath);
				}
			}
				
		}
			
	}
	
}

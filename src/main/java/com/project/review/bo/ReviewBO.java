package com.project.review.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.review.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	@Autowired
	private FileManagerService fileManager;
	
	//글쓰기
	//input: mtId, userId, content, file
	//output: x
	public void addReview(int mtId, int userId, String userLoginId, String content, MultipartFile file) {
		String imagePath = null;
		
		//이미지가 있으면 업로드
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		reviewMapper.insertReview(mtId, userId, content, imagePath);
	}
	
}

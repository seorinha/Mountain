package com.project.review.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.review.mapper.ReviewMapper;

@Service
public class ReviewBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final int POST_MAX_SIZE = 3;
	
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

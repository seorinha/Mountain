package com.project.review.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.review.domain.Review;
import com.project.review.mapper.ReviewMapper;

@Service
public class ReviewBO {

	
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Autowired
	private FileManagerService fileManager;
	
	
	//리뷰 리스트 
	//input: mtId, userId
	//output: List<Review>
	public List<Review> getReviewListByMtId(int mtId) {
		return reviewMapper.selectReviewListByMtId(mtId);
		
	}
	
	
	//리뷰작성
	//input: 파라미터들
	//output: x
	public void addReview(int mtId, int userId, String userLoginId, String content, MultipartFile file) {
		String imagePath = null;
		
		//이미지 있으면 업로드
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		
		reviewMapper.insertReview(mtId, userId, content, imagePath);
	}
	
	
}

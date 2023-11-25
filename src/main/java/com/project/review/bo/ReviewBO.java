package com.project.review.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.review.mapper.ReviewMapper;

@Service
public class ReviewBO {

	
	@Autowired
	private ReviewMapper reviewMapper;
	
	//글쓰기
	//input: 파라미터들
	//output: x
	public void addReview(int mtId, int userId, String content) {
		String imagePath = null;
		
		//TODO 이미지 잇으면 업로드
		
		reviewMapper.insertReview(mtId, userId, content, imagePath);
	}
	
	
}

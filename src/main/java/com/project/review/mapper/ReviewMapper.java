package com.project.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.review.domain.Review;

@Repository
public interface ReviewMapper {

	//리뷰 리스트
	public List<Review> selectReviewListByMtIdUserId(int mtId, int userId);
	
	//글쓰기
	public void insertReview(
			@Param("mtId") int mtId, 
			@Param("userId") int userId, 
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	
	
}

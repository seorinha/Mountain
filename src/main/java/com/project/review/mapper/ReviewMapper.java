package com.project.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.review.domain.Review;

@Repository
public interface ReviewMapper {

	//리뷰 리스트
	public List<Review> selectReviewListByMtId(int mtId);
	
	//글쓰기
	public void insertReview(
			@Param("mtId") int mtId, 
			@Param("userId") int userId, 
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	//글 상세 가져오기
	public Review selectReviewByReviewIdUserId(
			@Param("reviewId") int reviewId, 
    		@Param("userId") int userId);
	
	//글 수정하기
	public void updateReviewByReviewIdUserId(
    		@Param("reviewId") int reviewId, 
    		@Param("userId") int userId, 
    		@Param("content") String content, 
    		@Param("imagePath") String imagePath);
}

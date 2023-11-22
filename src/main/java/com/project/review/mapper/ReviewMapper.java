package com.project.review.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewMapper {

	//후기 쓰기
	public void insertReview(
			@Param("mtId") int mtId,
			@Param("userId") int userId,
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	
}

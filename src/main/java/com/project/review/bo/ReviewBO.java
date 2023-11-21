package com.project.review.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.FileManagerService;

@Service
public class ReviewBO {

	@Autowired
	private FileManagerService fileManager;
	
	//글쓰기
	//input: mtId, userId, content, file
	//output: x
	public void addReview(int mtId, int userId) {
		
	}
	
}

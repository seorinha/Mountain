package com.project.info.domain;

import com.project.mountain.domain.Mountain;
import com.project.review.domain.Review;

import lombok.Data;

//mountain 1개와 mapping
//info 하나 = mountain 1개
@Data 
public class Info {

	//mountain 1개 정보
	private Mountain mountain;
	
	//후기 1개 정보
	private Review review;
	
	
}

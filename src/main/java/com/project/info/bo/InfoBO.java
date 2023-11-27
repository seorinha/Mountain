package com.project.info.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.info.domain.Info;
import com.project.review.bo.ReviewBO;

@Service
public class InfoBO {

	@Autowired
	private ReviewBO reviewBO;
	
	//input:mtId, userId
	//output:List<info>
	public List<Info> generatedInfoList(Integer mtId, Integer userId) {
		List<Info> infoList = new ArrayList<>();
		
		
		
		//리뷰 목록을 가져온다
		
	}
}

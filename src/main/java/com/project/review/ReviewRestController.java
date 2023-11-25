package com.project.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.review.bo.ReviewBO;

@RequestMapping("/review")
@RestController
public class ReviewRestController {

	@Autowired
	private ReviewBO reviewBO;	
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("content") String content,
			HttpSession session) {
		
		//session의 유저id꺼낸다
		int mtId = (int)session.getAttribute("mtId");
		int userId = (int)session.getAttribute("userId");
		
		
		//db insert
		reviewBO.addReview(mtId, userId, content);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		
		return result;
	}
}

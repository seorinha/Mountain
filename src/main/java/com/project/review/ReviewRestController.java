package com.project.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.review.bo.ReviewBO;

@RequestMapping("/review")
@RestController
public class ReviewRestController {

	@Autowired
	private ReviewBO reviewBO;	
	
	/**
	 * 리뷰 작성
	 * @param mtId
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("mtId") int mtId,
			@RequestParam("content") String content,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) {
		
	
		 int userId = (int)session.getAttribute("userId");
		 String userLoginId = (String)session.getAttribute("userLoginId");
		
		
		//db insert
		reviewBO.addReview(mtId, userId, userLoginId, content, file);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		
		
		result.put("code", 200);
		result.put("result", "성공");
		
		
		return result;
	}
	
	
	/**
	 * 리뷰 수정
	 * @param reviewId
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@PutMapping("/update")
	public Map<String, Object> update(			
			@RequestParam("reviewId") int reviewId,
			@RequestParam("content") String content,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) {
		
		int userId = (int)session.getAttribute("userId"); 
		String userLoginId = (String)session.getAttribute("userLoginId");  //키가 기억 안나면 userRestController 확인
		
		//db update
		reviewBO.updateReview(userId, userLoginId, reviewId, content, file);
		
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	//글 삭제하기
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("reviewId") int reviewId,
			HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		
		//삭제
		reviewBO.deleteReviewByReviewIdUserId(reviewId, userId);
				
		//응답값
		Map<String, Object> result = new HashMap<>();
		
		result.put("code", 200);
		result.put("result", "성공");
			
		return result;
	}
	
	
}

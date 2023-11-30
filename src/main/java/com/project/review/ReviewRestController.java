package com.project.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.mountain.domain.Mountain;
import com.project.review.bo.ReviewBO;

@RequestMapping("/review")
@RestController
public class ReviewRestController {

	@Autowired
	private ReviewBO reviewBO;	
	
	/**
	 * 
	 * @param content
	 * @param file
	 * @param request
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("content") String content,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		
		Mountain mountain = new Mountain();
		int mtId = mountain.getId();
		
		HttpSession session = request.getSession();
		 session.setAttribute("mtId", mtId);
		
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
	
	
	//글 수정하기
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
}

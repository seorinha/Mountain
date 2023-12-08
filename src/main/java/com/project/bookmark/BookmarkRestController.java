package com.project.bookmark;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookmark.bo.BookmarkBO;

@RestController
public class BookmarkRestController {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@RequestMapping("/bookmark/{mtId}")
	public Map<String, Object> bookmarkToggle(
			@PathVariable int mtId,
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		
		//로그인 여부를 확인 
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인을 해주세요");
			
			return result;
		}
		
		bookmarkBO.bookmarkToggle(mtId, userId);
		
		//응답값
		result.put("code", 200);
		result.put("result", "성공");
				
		return result;
	}
	
}

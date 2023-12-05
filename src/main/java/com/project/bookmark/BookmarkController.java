package com.project.bookmark;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookmarkController {

	
	@GetMapping("/bookmark/bookmark-view")
	public String bookmarkView(
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		model.addAttribute("viewName", "bookmark/bookmark");
		return "template/layout";
	}
}

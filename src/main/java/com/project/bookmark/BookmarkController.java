package com.project.bookmark;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.mountain.bo.MountainBO;
import com.project.mountain.domain.Mountain;

@Controller
public class BookmarkController {

	@Autowired
	private MountainBO mountainBO;
	
	@GetMapping("/bookmark/bookmark-view")
	public String bookmarkView(
			@RequestParam("mtId") int mtId,
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		model.addAttribute("mtId", mtId);
		model.addAttribute("viewName", "bookmark/bookmark");
		return "template/layout";
	}
}

package com.project.bookmark;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bookmark.bo.BookmarkBO;
import com.project.bookmark.domain.Bookmark;
import com.project.mountain.bo.MountainBO;
import com.project.mountain.domain.Mountain;

@RequestMapping("/bookmark")
@Controller
public class BookmarkController {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@Autowired
	private MountainBO mountainBO;
	
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		//List<Mountain> mountainList = mountainBO.getMountainBookmark();
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkListByUserId(userId);
		
		for (Bookmark bookmark : bookmarkList) {
	        Mountain mountain = mountainBO.getMountainById(bookmark.getMtId());
	        bookmark.setMountain(mountain);
	    }
		
		//model.addAttribute("mountainList", mountainList);		
		model.addAttribute("bookmarkList", bookmarkList);		
		model.addAttribute("viewName", "bookmark/bookmark");
		return "template/layout";
	}
}

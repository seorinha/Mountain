package com.project.mountain;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bookmark.bo.BookmarkBO;
import com.project.bookmark.entity.BookmarkEntity;
import com.project.mountain.bo.MountainBO;
import com.project.mountain.domain.Mountain;
import com.project.review.bo.ReviewBO;
import com.project.review.domain.Review;

@RequestMapping("/mountain")
@Controller
public class MountainController {

	@Autowired
	private MountainBO mountainBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	/**
	 * 산 정보, 후기리스트 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/mountain-review-view")
	public String mountainReviewView(
			@RequestParam("mtId") int mtId, 
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		Mountain mountain = mountainBO.getMountainById(mtId);
		BookmarkEntity bookmark = bookmarkBO.getBookmarkByMtId(mtId);
		List<Review> reviewList = reviewBO.getReviewListByMtId(mtId);
		
		
		model.addAttribute("bookmark", bookmark);
		model.addAttribute("mountain", mountain);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("viewName", "mountain/mountain");
		return "template/layout";
	}
}

package com.project.mountain;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	/**
	 * 산 정보, 후기리스트 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/mountain-review-view")
	public String mountainReviewView(
			@ModelAttribute Mountain mountain,
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		
		Mountain newMountain = mountainBO.getMountain(mountain.getId());
		
		List<Review> reviewList = reviewBO.getReviewListByMtIdUserId(id, userId);
		
		
		model.addAttribute("mountain", newMountain);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("viewName", "mountain/mountain");
		return "template/layout";
	}
}

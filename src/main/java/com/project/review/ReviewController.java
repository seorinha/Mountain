package com.project.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.review.bo.ReviewBO;
import com.project.review.domain.Review;

@RequestMapping("/review")
@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	/**
	 * 리뷰 작성 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/review-create-view")
	public String reviewCreateView(
			@RequestParam("mtId") int mtId,
			Model model) {
		
		model.addAttribute("mtId", mtId);
		model.addAttribute("viewName", "review/reviewCreate");
		return "template/layout";
	}
	
	
	/**
	 * 리뷰 상세 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/review-detail-view")
	public String reviewDetailView(
			@RequestParam ("reviewId") int reviewId,
			@RequestParam("view") int view,
			HttpSession session,
			Model model) {
		
		int userId = (int)session.getAttribute("userId");
		
		Review review = reviewBO.getReviewByReviewIdUserId(reviewId, userId);
		
		model.addAttribute("review", review);
		model.addAttribute("reviewId", reviewId);
		model.addAttribute("view", view);
		model.addAttribute("viewName", "review/reviewDetail");
		return "template/layout";
	}
	
	
}

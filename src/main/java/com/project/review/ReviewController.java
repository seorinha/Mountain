package com.project.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/review")
@Controller
public class ReviewController {

	/**
	 * 리뷰 작성 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/review-create-view")
	public String reviewCreateView(Model model) {
		model.addAttribute("viewName", "review/reviewCreate");
		return "template/layout";
	}
	
	
	/**
	 * 리뷰 상세 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/review-detail-view")
	public String reviewDetailView(Model model) {
		model.addAttribute("viewName", "review/reviewDetail");
		return "template/layout";
	}
	
}

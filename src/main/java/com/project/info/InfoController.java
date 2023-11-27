package com.project.info;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.review.bo.ReviewBO;
import com.project.review.domain.Review;

@RequestMapping("/info")
@Controller
public class InfoController {

	
	
	
	/**
	 * 산 정보, 후기리스트 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/info-review-view")
	public String infoView(Model model, HttpSession session) {
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		
		model.addAttribute("info", "info");
		model.addAttribute("viewName", "info/info");
		return "template/layout";
	}
	
}

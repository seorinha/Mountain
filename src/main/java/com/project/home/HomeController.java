package com.project.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {

	/**
	 * 홈 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/home-list-view")
	public String homeListView(Model model) {
		model.addAttribute("viewName", "home/home");
		return "template/layout";
	}
	
}

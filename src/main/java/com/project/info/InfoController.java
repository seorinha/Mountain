package com.project.info;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/info")
@Controller
public class InfoController {

	/**
	 * 산 정보, 후기리스트 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/info-review-view")
	public String infoView(Model model) {
		model.addAttribute("viewName", "info/info");
		return "template/layout";
	}
	
}

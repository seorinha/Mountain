package com.project.diary;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiaryController {

	
	@GetMapping("/diary/diary-view")
	public String diaryView(
			Model model) {
			//HttpSession session
		//Integer userId = (Integer)session.getAttribute("userId");
		
		model.addAttribute("viewName", "diary/diary");
		return "template/layout";
	
	}
	
}

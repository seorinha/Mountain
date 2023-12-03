package com.project.diary;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.diary.bo.DiaryBO;
import com.project.diary.domain.CardView;

@Controller
public class DiaryController {

	@Autowired
	private DiaryBO diaryBO;
	
	@GetMapping("/diary/diary-view")
	public String diaryView(
			Model model,
			HttpSession session) {
			
		Integer userId = (Integer)session.getAttribute("userId");
		
		List<CardView> cardViewList = diaryBO.generateCardViewList(userId);
		
		model.addAttribute("cardList", cardViewList);
		model.addAttribute("viewName", "diary/diary");
		return "template/layout";
	
	}
	
}

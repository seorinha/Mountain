package com.project.home;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.mountain.bo.MountainBO;
import com.project.mountain.domain.Mountain;

@RequestMapping("/home")
@Controller
public class HomeController {

	@Autowired
	private MountainBO mountainBO;
	
	/**
	 * 홈 화면 뷰
	 * @param model
	 * @return
	 */
	@GetMapping("/home-list-view")
	public String homeListView(Model model) {
		
		List<Mountain> mountainList = mountainBO.getMountainList();
		
		model.addAttribute("mountainList", mountainList);
		model.addAttribute("viewName", "home/home");
		return "template/layout";
	}
	
}

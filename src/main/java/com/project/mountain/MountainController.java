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
import com.project.bookmark.domain.Bookmark;
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
			@RequestParam(value = "prevId", required = false) Integer prevIdParam, 
			@RequestParam(value = "nextId", required = false) Integer nextIdParam, 
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 화면으로 이동
			return "redirect:/user/sign-in-view";
		}
		
		Mountain mountain = mountainBO.getMountainById(mtId);
		Bookmark bookmark = bookmarkBO.getBookmarkByMtIdUserId(mtId, userId);
		List<Review> reviewList = reviewBO.getReviewListByMtId(mtId, prevIdParam, nextIdParam);
		int nextId = 0;
		int prevId = 0;
		if (reviewList.isEmpty() == false) {
			//reviewList가 비어있을 때 오류를 방지하기 위함  []
			nextId = reviewList.get(reviewList.size() - 1).getId(); //가져온 리스트의 리뷰의 id를 가져온다(가장 큰값 = 가장 작은 id)
			prevId = reviewList.get(0).getId(); 
			
			//이전 방향의 끝인가?
			if (reviewBO.isPrevLastPageByUserId(prevId, userId)) {
				prevId = 0;
			}
			
			//다음 방향의 끝인가?
			if (reviewBO.isNextLastPageByUserId(nextId, userId)) {
				nextId = 0;
			}
 		}
		
		model.addAttribute("mtId", mtId);
		model.addAttribute("bookmark", bookmark);
		model.addAttribute("mountain", mountain);
		model.addAttribute("prevId", prevId);
		model.addAttribute("nextId", nextId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("viewName", "mountain/mountain");
		return "template/layout";
	}
}

package com.project.review.bo;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.FileManagerService;
import com.project.review.domain.Review;
import com.project.review.mapper.ReviewMapper;

@Service
public class ReviewBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	private static final int POST_MAX_SIZE = 3; 
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Autowired
	private FileManagerService fileManager;
	
	
	//리뷰 리스트 
	//input: mtId, userId
	//output: List<Review>
	public List<Review> getReviewListByMtId(int mtId, Integer prevId, Integer nextId) {
		
		String direction = null; //방향
		Integer standardId = null; // 기준이 되는 reviewId
		if (prevId != null) { //이전
			direction = "prev";
			standardId = prevId;
			
			List<Review> reviewList = reviewMapper.selectReviewListByMtId(mtId, direction, standardId, POST_MAX_SIZE);
					
			//reverse 5 6 7 -> 7 6 5
			Collections.reverse(reviewList); //뒤집고 저장
			
			return reviewList;
					
		} else if (nextId != null) { //다음
			direction = "next";
			standardId = nextId;
		}
		
		return reviewMapper.selectReviewListByMtId(mtId, direction, standardId, POST_MAX_SIZE);
	}
	
	//이전 페이지의 마지막인가?
	public boolean isPrevLastPageByMtId(int prevId, int mtId) {
		int reviewId = reviewMapper.selectReviewIdByMtIdAndSort(mtId, "DESC");
		return reviewId == prevId; //같으면 끝 true, 아니면 false
	}
		
	//다음 페이지의 마지막인가
	public boolean isNextLastPageByMtId(int nextId, int mtId) {
		int reviewId = reviewMapper.selectReviewIdByMtIdAndSort(mtId, "ASC");
		return reviewId == nextId; //같으면 끝 true, 아니면 false
	}
		
	
	
	//리뷰작성
	//input: 파라미터들
	//output: x
	public void addReview(int mtId, int userId, String userLoginId, String content, MultipartFile file) {
		String imagePath = null;
		
		//이미지 있으면 업로드
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		
		reviewMapper.insertReview(mtId, userId, content, imagePath);
	}
	
	//글 상세 가져오기
	//input: reviewId, userId
	//output: Review
	public Review getReviewByReviewIdUserId(int reviewId, int userId) {
		return reviewMapper.selectReviewByReviewIdUserId(reviewId, userId); 
	}
	
	
	//글 수정하기
	//input:userId, userLoginId, reviewId, content, file
	//output:x
	public void updateReview(int userId, String userLoginId, int reviewId, 
			String content, MultipartFile file) {
	
		//먼저 기존 글을 가져와본다.(1. 이미지 교체시 삭제를 위해서, 2. 업데이트 대상이 있는지 확인하기 위해) 
				Review review = reviewMapper.selectReviewByReviewIdUserId(reviewId, userId);
				if (review == null) { //review가 null? 이럴리가 없는데 
					logger.error("[후기 수정] review is null.  review id:{}, userId:{}", reviewId, userId); //에러수준일때
					//logger.info(); //에러까진 아니고 조심 해야 될정도
					return;
				}
				
				//파일이 있다면 
				//1. 새로운 이미지를 업로드한다
				//2  새 이미지 업로드 성공시 기존 이미지를 제거한다(기존 이미지가 있을 때 제거)
				String imagePath = null;
				if (file != null) {
					//업로드
					imagePath = fileManager.saveFile(userLoginId, file);
					
					//업로드 성공시 기존 이미지 제거(이미지가 잇다면)
					if (imagePath != null && review.getImagePath() != null) { //업로드가 성공을 했고, 기존이미지가 존재한다면 삭제를 한다
						//이미지 제거
						fileManager.deleteFile(review.getImagePath());
					}
				}
				
				//db 글 업데이트
				reviewMapper.updateReviewByReviewIdUserId(reviewId, userId, content, imagePath);
				
			}
	
	
	//글 삭제하기
	//input:reviewId, userId
	//output:x
	public void deleteReviewByReviewIdUserId(int reviewId, int userId) {
		// 기존 글 가져옴(이미지가 있으면 삭제야하기 떼문)
		Review review = reviewMapper.selectReviewByReviewIdUserId(reviewId, userId);
		if (review == null) {
			logger.info("[후기 삭제] review가 null. reviewId:{}, userId:{}", reviewId, userId);
			return;
		}
		//기존 이미지가 존재하면 -> 삭제
		if (review.getImagePath() !=null) {
			fileManager.deleteFile(review.getImagePath());
		}
		
		//db 삭제
		reviewMapper.deleteReviewByReviewIdUserId(reviewId, userId);
	}
	
	
	//조회수
	public void updateReviewView(int reviewId) {
		reviewMapper.updateReviewView(reviewId);
	}
	
}

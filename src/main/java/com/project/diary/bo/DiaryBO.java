package com.project.diary.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.comment.bo.CommentBO;
import com.project.comment.domain.CommentView;
import com.project.diary.domain.CardView;
import com.project.like.bo.LikeBO;
import com.project.post.bo.PostBO;
import com.project.post.entity.PostEntity;
import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@Service
public class DiaryBO {

	@Autowired
	private PostBO postBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	//다이어리 카드 구성
	//input : userId(비로그인/로그인 허용 null도 허용)
	//output: List<cardView>
	public List<CardView> generateCardViewList(Integer userId) { //화면용으로 가공할 때는 보통 generate 사용
		List<CardView> cardViewList = new ArrayList<>(); // [] 비어있는 리스트
		
		//글 목록을 가져오기
		List<PostEntity> postList = postBO.getPostList();
		
		//글목록 반복문 순회      
		for (PostEntity post : postList) { // 글이 3개일 때 : 0 1 2 
			
			//post 하나에 대응되는 하나의 카드를 만든다
			CardView cardView = new CardView();
			
			//글 1개
			cardView.setPost(post);
			
			//글쓴이 정보세팅 userbo에게 id로 조회하겟다고 함
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			cardView.setUser(user);
			
			//댓글
			List<CommentView> commentList = commentBO.generateCommentViewListByPostId(post.getId());
			cardView.setCommentList(commentList);
			
			//좋아요 갯수
			int likeCount = likeBO.getLikeCountByPostId(post.getId());
			cardView.setLikeCount(likeCount);
			
			//내가 좋아요 눌렀는지
			boolean filledLike = likeBO.filledLike(post.getId(), userId);
			cardView.setFilledLike(filledLike);
			
			
			cardViewList.add(cardView);
		}
		return cardViewList;
	}
	
}

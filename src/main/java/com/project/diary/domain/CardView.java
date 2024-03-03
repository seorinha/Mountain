package com.project.diary.domain;

import java.util.Date;
import java.util.List;

import com.project.comment.domain.CommentView;
import com.project.post.entity.PostEntity;
import com.project.user.entity.UserEntity;

import lombok.Data;

@Data
public class CardView {

	//글 1개 정보
	private PostEntity post;
		
	//글쓴이 정보
	private UserEntity user;
	
	//글 작성 날짜 
	private Date createdAt;
	
	//댓글
	private List<CommentView> commentList;
	
	//좋아요 갯수
	private int likeCount;
	
	//좋아요 눌렀나 
	private boolean filledLike;
	

}

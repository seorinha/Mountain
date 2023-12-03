package com.project.diary.domain;

import com.project.post.entity.PostEntity;
import com.project.user.entity.UserEntity;

import lombok.Data;

@Data
public class CardView {

	//글 1개 정보
	private PostEntity post;
		
	//글쓴이 정보
	private UserEntity user;
	
	//댓글
	
	//좋아요 갯수
	
	//좋아요 눌렀나 
	
	

}

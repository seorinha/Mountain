package com.project.comment.domain;

import com.project.user.entity.UserEntity;

import lombok.Data;

@Data
public class CommentView {

	private UserEntity user;
	
	private Comment comment;
}

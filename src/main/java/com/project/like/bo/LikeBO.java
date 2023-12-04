package com.project.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.like.mapper.LikeMapper;

@Service
public class LikeBO {

	@Autowired
	private LikeMapper likeMapper;
	
	//좋아요 누르기 해제하기
	//input:userId, postId
	//output:x
	public void likeToggle(int postId, int userId) {
		if (likeMapper.selectLikeCountByPostIdUserId(postId, userId) > 0) {
			//삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else {
			//추가
			likeMapper.insertLike(postId, userId);
		}
	}
	
}

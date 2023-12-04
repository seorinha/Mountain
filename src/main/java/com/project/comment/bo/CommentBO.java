package com.project.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.comment.domain.Comment;
import com.project.comment.domain.CommentView;
import com.project.comment.mapper.CommentMapper;
import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@Service
public class CommentBO {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private UserBO userBO; 
	
	//댓글 쓰기
	//input:postId, userId, content
	//output:x
	public void addComment(int postId, int userId, String content) {
		commentMapper.insertComment(postId, userId, content);
	}
	
	//글 1개당 댓글List 생성
	//input:postId
	//output:List<CommentView>
	public List<CommentView> generateCommentViewListByPostId(int postId) {
		
		List<CommentView> commentViewList = new ArrayList<>();  //[] 비어잇음
		
		//글 1개당 댓글들(List<Comment>) 목록 가져오기 
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
		
		//반복문 순회
		//List<Comment> -> List<CommentView>
		for (Comment comment : commentList) {
			CommentView commentView = new CommentView();
			
			//댓글 내용 담기
			commentView.setComment(comment);
			
			//댓글쓴이 내용 담기
			UserEntity user = userBO.getUserEntityById(comment.getUserId());
			commentView.setUser(user);
			
			commentViewList.add(commentView);
		}
		return commentViewList;
	}
	
	//댓글 삭제
	//input:commentId
	//output:x
	public void deleteCommentById(int id) {
		commentMapper.deleteCommentById(id);
	}
	
}

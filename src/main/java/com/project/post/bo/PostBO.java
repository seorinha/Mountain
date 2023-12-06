package com.project.post.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.comment.bo.CommentBO;
import com.project.common.FileManagerService;
import com.project.like.bo.LikeBO;
import com.project.post.entity.PostEntity;
import com.project.post.repository.PostRepository;

@Service
public class PostBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PostRepository postRepository;	

	@Autowired
	private FileManagerService fileManager;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	//다이어리 카드구성
	//input:x
	//output:List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	//글쓰기
	//input:userId, content, file
	//output:x
	public PostEntity addPost(int userId, String userLoginId, String content, MultipartFile file) {
		String imagePath = null;
		
		// 이미지가 있으면 업로드 
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		
		return postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.content(content)
				.imagePath(imagePath)
				.build());
	}
	
	//글 삭제
	public void deletePostByPostIdUserId(int postId, int userId) {
		// 기존 글 => 이미지 삭제
		PostEntity post = postRepository.findById(postId).orElse(null);
		if (post == null) {
			logger.error("[delete post] postId:{}, userId:{}", postId, userId);
			return;
		}

		// 이미지 있으면 이미지 삭제
		if (post.getImagePath() != null) {
			fileManager.deleteFile(post.getImagePath());
		}
		
		// db 글 삭제
		postRepository.delete(post);
					
		// db 댓글 삭제
		commentBO.deleteCommentsByPostId(postId);
					
		// db 좋아요
		likeBO.deleteLikeByPostId(postId);
		
	}
	
}

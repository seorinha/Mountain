package com.project.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{

	//다이어리 카드구성
	public List<PostEntity> findAllByOrderByIdDesc();
	
	
	
}

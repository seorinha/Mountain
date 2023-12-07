package com.project.bookmark.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookmark.entity.BookmarkEntity;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Integer> {

	
	//북마크 누르기, 해제하기
	public int selectBookmarkByMtIdUserId(
			@Param("mtId") int mtId,
			@Param("userId") Integer userId);
	
	public void insertBookmark(
			@Param("mtId") int mtId,
			@Param("userId") int userId);

	
	public void deleteBookmarkByMtIdUserId(
			@Param("mtId") int mtId,
			@Param("userId") int userId);
	
	//mountain에 bookmark
	public BookmarkEntity selectBookmarkByMtId(int id);
	
}

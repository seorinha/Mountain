package com.project.bookmark.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.bookmark.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	
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
	public Bookmark selectBookmarkByMtId(int id);
	
}

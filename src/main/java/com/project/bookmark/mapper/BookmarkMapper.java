package com.project.bookmark.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.bookmark.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	//즐겨찾기 누르기 + 즐겨찾기 갯수 두가지 메소드를 합친 것
	public int selectBookmarkCountByMtIdOrUserId(
			@Param("mtId") int mtId,
			@Param("userId") Integer userId);
	
	public void insertBookmark(
			@Param("mtId") int mtId,
			@Param("userId") int userId);

	
	public void deleteBookmarkByMtIdUserId(
			@Param("mtId") int mtId,
			@Param("userId") int userId);
	
	
	
	//mountain의 bookmark
	public Bookmark selectBookmarkByMtIdUserId(int mtId, int userId);
	
	
	
}

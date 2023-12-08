package com.project.bookmark.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.bookmark.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	public void insertBookmark(
			@Param("mtId") int mtId, 
			@Param("userId") int userId);
	
	public Bookmark selectBookmarkByMtId(int mtId);
}

package com.project.bookmark.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookmark.domain.Bookmark;
import com.project.bookmark.mapper.BookmarkMapper;
import com.project.mountain.domain.Mountain;
import com.project.user.entity.UserEntity;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(int mtId, int userId) {
		bookmarkMapper.insertBookmark(mtId, userId);
	}
	
	//
	public Bookmark getBookmarkByMtId(int mtId) {
		return bookmarkMapper.selectBookmarkByMtId(mtId);
	}
	
}

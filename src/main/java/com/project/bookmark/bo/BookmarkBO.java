package com.project.bookmark.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookmark.domain.Bookmark;
import com.project.bookmark.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	//즐겨찾기 누르기, 해제하기
	//input:mtId, userId
	//output:x
	public void bookmarkToggle(int mtId, int userId) {
		if (bookmarkMapper.selectBookmarkByMtIdUserId(mtId, userId) > 0) {
			bookmarkMapper.deleteBookmarkByMtIdUserId(mtId, userId);
		} else {
			bookmarkMapper.insertBookmark(mtId, userId);
		}
	}
	
	//input:mtId, userId(Integer)
	//output: 채워졌는지 여부(boolean true false)
	public boolean filledBookmark(int mtId, Integer userId) {
		//비로그인
		if (userId == null) {
			return false;
		}
		
		//로그인
		//0보다 큰 경우 있음(채워진 하트 true), 그렇지 않으면 false(빈하트)
		return bookmarkMapper.selectBookmarkByMtIdUserId(mtId, userId) > 0;
		
	}
	
	//mountain에 bookmark
	public Bookmark getBookmarkByMtId(int id) {
		return bookmarkMapper.selectBookmarkByMtId(id);
	}
}

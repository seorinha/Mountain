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
	
	
	//즐겨찾기 누르기, 해제하기
	//input:userId, mtId 
	//output:x
	public void bookmarkToggle(int mtId, int userId) {
		//셀렉트 -> count(*)
		if (bookmarkMapper.selectBookmarkCountByMtIdOrUserId(mtId, userId) > 0) {
			//삭제
			bookmarkMapper.deleteBookmarkByMtIdUserId(mtId, userId);
		} else {
			//추가
			bookmarkMapper.insertBookmark(mtId, userId);
		}
	}
			
			
	//즐겨찾기 갯수
	//input: mtId
	//output: 개수(int)
	public int getBookmarkCountByMtId(int mtId) {
		return bookmarkMapper.selectBookmarkCountByMtIdOrUserId(mtId, null);
	}
			
			
	//input: mtId , userId(Integer)
	//output: 채워졌는지(boolean)
	public boolean filledBookmark(int mtId, Integer userId) {
		//비로그인
		if (userId == null) {
			return false;
		}
				
		//로그인
		//0보다 큰 경우 있음(채워진 하트 true), 그렇지 않으면 false(빈하트)
		return bookmarkMapper.selectBookmarkCountByMtIdOrUserId(mtId, userId) > 0;
				
	}
	
	//mountain에 bookmark
	public Bookmark getBookmarkByMtIdUserId(int mtId, int userId) {
		return bookmarkMapper.selectBookmarkByMtIdUserId(mtId, userId);
	}
	
	//즐겨찾기에 목록 
	public List<Bookmark> getBookmarkListByUserId(int userId) {
		return bookmarkMapper.selectBookmarkListByUserId(userId);
	}
	
	//
	public Bookmark getBookmarkByMtId(int mtId) {
		return bookmarkMapper.selectBookmarkByMtId(mtId);
	}
}

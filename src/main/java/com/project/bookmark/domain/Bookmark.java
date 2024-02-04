package com.project.bookmark.domain;

import java.util.Date;

import com.project.mountain.domain.Mountain;

import lombok.Data;

@Data
public class Bookmark {

	
	private int id;
	private int mtId;
	private int userId;
	private Mountain mountain; 
	private Date createdAt;
	private Date updatedAt;
	
	
}

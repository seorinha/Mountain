package com.project.bookmark.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Bookmark {

	
	private int id;
	private int mtId;
	private int userId;
	private Date createdAt;
	private Date updatedAt;
	
	
}

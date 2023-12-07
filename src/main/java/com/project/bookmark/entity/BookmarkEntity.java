package com.project.bookmark.entity;

import java.util.Date;

import lombok.Data;

@Data
public class BookmarkEntity {

	private int id;
	private int mtId;
	private int userId;
	private Date createdAt;
	private Date updatedAt;
}

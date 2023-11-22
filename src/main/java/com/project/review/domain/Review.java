package com.project.review.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Review {

	private int id;
	private int mtId;
	private int userId;
	private String content;
	private String imagePath;
	private Date createdAt;
	private Date updatedAt;
}

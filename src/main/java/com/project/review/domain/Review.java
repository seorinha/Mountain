package com.project.review.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Review {

	private int id;
	private int mtId;
	private int userId;
	private String loginId;
	private String content;
	private String imagePath;
	private int view;
	private Date createdAt;
	private Date updatedAt;
}

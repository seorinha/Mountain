package com.project.info.domain;

import java.util.Date;

import com.project.review.domain.Review;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Info {

	private int id;
	private String mtName;
	private String mtMap;
	private String mtLocation;
	private int mtHeight;
	private String mtReason;
	private int upMin;
	private int downMin;
	private String difficulty;
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
        return id;
    }
	
}

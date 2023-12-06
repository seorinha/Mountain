package com.project.mountain.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Mountain {

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
	
	private boolean filledBookmark;
}

package com.project.mountain.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class Mountain {

	private int id;
	private String mtName;
	private String mtLocation;
	private double mtHeight;
	private double mtLot;
	private double mtLat;
	private Date createdAt;
	private Date updatedAt;
	
	
	
	
}

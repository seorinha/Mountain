package com.project.mountain.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mountain")
@Entity
public class MountainEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "mtName")
	private String mtName;

	@Column(name = "mtLocation")
	private String mtLocation;
	
	@Column(name = "mtHeight")
	private double mtHeight;
	
	@Column(name = "mtLot", precision =13, scale = 10) //13자리 중 소수점아래가 10자리까지 확보되었다
	private BigDecimal mtLot;
	
	@Column(name = "mtLat", precision =13, scale = 10)
	private BigDecimal mtLat;
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
	
}

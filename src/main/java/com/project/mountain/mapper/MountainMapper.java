package com.project.mountain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mountain.domain.Mountain;

@Repository
public interface MountainMapper {

	public Mountain selectMountainById(int id);
	
	//home
	public List<Mountain> selectMountainList();
	
}

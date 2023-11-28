package com.project.mountain.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.mountain.domain.Mountain;

@Repository
public interface MountainMapper {

	public Mountain selectMountainByMtId(
			@Param("mtId") int mtId);
	
}

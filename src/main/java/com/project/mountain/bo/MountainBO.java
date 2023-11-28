package com.project.mountain.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mountain.domain.Mountain;
import com.project.mountain.mapper.MountainMapper;

@Service
public class MountainBO {

	@Autowired
	private MountainMapper mountainMapper;
	
	//input:mtId
	//output:Mountain
	public Mountain getMountainByMtId(int mtId) {
		return mountainMapper.selectMountainByMtId(mtId);
	}
}

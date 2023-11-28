package com.project.mountain.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mountain.domain.Mountain;
import com.project.mountain.mapper.MountainMapper;

@Service
public class MountainBO {

	@Autowired
	private MountainMapper mountainMapper;
	
	//input:
	//output:Mountain
	public Mountain getMountain(int id) {
		return mountainMapper.selectMountain(id);
	}
	
	//home
	public List<Mountain> getMountainList() {
		return mountainMapper.selectMountainList();
	}
	
}

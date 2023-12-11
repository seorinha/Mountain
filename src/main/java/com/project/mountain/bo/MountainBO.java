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
	public Mountain getMountainById(int id) {
		return mountainMapper.selectMountainById(id);
	}
	
	//home
	public List<Mountain> getMountainList() {
		return mountainMapper.selectMountainList();
	}
	
	//즐겨찾기에 정보 
	public Mountain getMountain() {
		return mountainMapper.selectMountain();
	}
	
}

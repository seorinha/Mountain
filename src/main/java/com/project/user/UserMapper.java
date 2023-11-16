package com.project.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

	public List<Map<String, Object>> selectUserList();
		
	
}

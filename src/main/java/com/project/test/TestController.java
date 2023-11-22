package com.project.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.user.repository.UserRepository;

@Controller
public class TestController {

	@Autowired
	private UserRepository userMapper;
	
	//1. string + response body
	@ResponseBody
	   @RequestMapping("/test1")
	   public String helloWorld() {
	       return "Hello world!";
	   }
	 
	//2. map + response body -> json
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2() {
		Map<String, Object> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		return map;
	}
	
	//3. jsp 확인 -> html
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	//4. db연동 확인 -> json
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4() {
		return userMapper.selectUserList();
	}
	 
}

package com.project.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;
	
	//아이디 중복 확인
	//input:loginId
	//output:userEntity(null이거나 entity)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	//회원가입 
	//input:loginId, password, name, email
	//output: id(pk)
	public Integer addUser(String loginId, String password, String name, String email) {
		UserEntity userEntity = userRepository.save(
				UserEntity.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email)
				.build());
		
		return userEntity == null ? null : userEntity.getId();
	}
	
	//로그인 
	//input:loginId, password
	//output:useEntity
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
	

	//댓글 뿌릴 때 id로만 조회하는게 필요해서 만든 메소드
		public UserEntity getUserEntityById(int userId) {
			return userRepository.findById(userId).orElse(null); 
		}
}

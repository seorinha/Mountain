package com.project.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	//아이디 중복확인
	//null or 채워져있음
	public UserEntity findByLoginId(String loginId);
		
	//로그인
	public UserEntity findByLoginIdAndPassword(String loginId, String password);

	//카카오 로그인 가입 비가입 체크
	public Optional<UserEntity> findByName(String name);
}

package com.project.mountain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mountain.entity.MountainEntity;

@Repository
public interface MountainRepository extends JpaRepository<MountainEntity, Integer> {

	
}

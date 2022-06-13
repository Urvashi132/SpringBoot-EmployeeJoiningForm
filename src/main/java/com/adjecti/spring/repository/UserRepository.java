package com.adjecti.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {	
	public User findByusername(String username);
}
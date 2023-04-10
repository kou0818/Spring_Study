package com.example.demo.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	//1-6 追記また、Optionalをインポートを実施
	Optional<Users> findByEmail(String email);
}
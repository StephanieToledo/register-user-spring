package com.register.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.users.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	Optional findById(long id);
	User findByEmail(String email);
}

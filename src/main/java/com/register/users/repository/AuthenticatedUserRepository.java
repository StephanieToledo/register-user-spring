package com.register.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.users.model.AuthenticatedUser;

public interface AuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, Long> {

	Optional<AuthenticatedUser> findByEmail(String email);
	
}

package com.register.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.users.dto.UserDTO;
import com.register.users.model.User;
import com.register.users.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired(required=true)
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> usersList(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id_user}")
	public ResponseEntity<?> getUsersById(@PathVariable Long id_user) {
		Optional getUser = userRepository.findById(id_user);
		
		UserDTO userDto = new UserDTO();
		
		if(getUser.isPresent()) {
			User user = (User) getUser.get();
			
			userDto.setId(user.getId());
			userDto.setName_user(user.getName_user());
			userDto.setEmail(user.getEmail());
			userDto.setPhone(user.getPhone());
			userDto.setAddress(user.getAddress());
			userDto.setNeighborhood(user.getNeighborhood());
			userDto.setNumber(user.getNumber());
			userDto.setComplement(user.getComplement());
		}
		return getUser.isPresent() ? ResponseEntity.ok(userDto) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/register")
	public User userRegister(@RequestBody User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}
	
}












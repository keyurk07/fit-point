package com.diet.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diet.auth.model.User;
import com.diet.auth.repository.UserRepository;

@RestController
public class UserController {

	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @PostMapping("/api/users")
	    public User createUser(@RequestBody User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
	        return userRepository.save(user);
	    }
	    
	    @GetMapping("/api/users")
	    public List<User> getAllUser(){
	    	return userRepository.findAll();
	    }
}

package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.client.AuthClient;
import com.user.entities.UserDTO;
import com.user.entities.UserDetails;
import com.user.service.UserService;

@RestController
@RequestMapping("/user/api")
@CrossOrigin
public class UserController {
	    @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private AuthClient authClient;

	    @GetMapping("/getAll")
	    public ResponseEntity<List<UserDetails>> getAllUsers() {
	        List<UserDetails> users = userService.getAllUsers();
//	        return new ResponseEntity<>(users, HttpStatus.OK);
	        return ResponseEntity.ok().body(users);
	    }

	    @GetMapping("/getById/{id}")
	    public ResponseEntity<UserDetails> getUserById(@PathVariable("id") long userId) {
	        return userService.getUserById(userId)
	                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    @GetMapping("/name/{name}")
	    public ResponseEntity<List<UserDetails>> findByName(@PathVariable("name") String userName)  {
	        List<UserDetails> users = userService.findByName(userName);
	        return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
	        UserDetails createdUser = userService.createUser(userDetails);
	        UserDTO user=new UserDTO();
	        user.setUsername(userDetails.getUserName());
	        user.setPassword(userDetails.getPassword());
	        authClient.registerUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<UserDetails> updateUser(@PathVariable("id") long userId, @RequestBody UserDetails userDetails) {
	    	Optional<UserDetails> newUserDetails = userService.getUserById(userId); 
	    	if(newUserDetails.isPresent()) {
	    		return ResponseEntity.ok().body(userService.updateUser(userId,userDetails));
	    	}
	    	else {
	    		return ResponseEntity.noContent().build();
	    	}
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable("id") long userId) {
	        userService.deleteUser(userId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}

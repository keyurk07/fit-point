package com.diet.auth.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diet.auth.model.User;
import com.diet.auth.repository.UserRepository;
import com.diet.auth.service.AuthService;
import com.diet.auth.service.JwtService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class AuthController {

	

    @Autowired
    private AuthService authService;
    
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/hello")
    public String hello() {
    	return "Welcome";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.saveUser(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
    	String token=authService.validateUser(user);
    	return new ResponseEntity<>(Map.entry("token", token),HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public Optional<User> getUserByEmail(@PathVariable String username) {
        return authService.findByUsername(username);
    }
    
    @PostMapping("/validate/token")
    public ResponseEntity<?> validateToken(@RequestParam String token){
    	return new ResponseEntity<>(authService.validateToken(token),HttpStatus.OK);
    }
}

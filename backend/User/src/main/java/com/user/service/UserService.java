package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.UserDetails;
import com.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public List<UserDetails> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserDetails> getUserById(long userId) {
        return userRepository.findById(userId);
    }
    
    public List<UserDetails> findByName(String userName) {
        return userRepository.findByUserName(userName); // Call the repository method
    }

    public UserDetails createUser(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    public UserDetails updateUser(long userId, UserDetails userDetails) {
        userDetails.setUserId(userId);
        return userRepository.save(userDetails);
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

}

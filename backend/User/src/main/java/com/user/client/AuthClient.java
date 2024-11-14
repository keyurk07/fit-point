package com.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.entities.UserDTO;

@FeignClient(name="auth", url="http://localhost:8081/user/")
public interface AuthClient {
	@PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO user);
	

}

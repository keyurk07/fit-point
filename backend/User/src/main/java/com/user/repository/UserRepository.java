package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entities.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	List<UserDetails> findByUserName(String userName);

}

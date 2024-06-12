package com.teleapps_user_details.service;

import org.springframework.http.ResponseEntity;

import com.teleapps_user_details.domain.User;

public interface UserService {

	User createUser(User user);

	ResponseEntity<String> deleteUserById(Long id);
	
	User getUserById(Long id);

	User assignedRoleToUser(Long user_id, Long role_id);
	
    User updateUser(User user, String updatedBy);
		
}

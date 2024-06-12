package com.teleapps_user_details.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;
import com.teleapps_user_details.domain.Role;
import com.teleapps_user_details.domain.User;
import com.teleapps_user_details.repository.RoleRepository;
import com.teleapps_user_details.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
  
    
	@Override
	@Transactional
    public User createUser(User user) 
	{
        return userRepository.save(user);
    }
	
    @Override
    @Transactional
    public User getUserById(Long id) 
    {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }


	@Override
	public ResponseEntity<String> deleteUserById(Long id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        userRepository.deleteById(id);
	        return ResponseEntity.ok("User with ID " + id + " deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not available");
	    }
	}

	
	
	@Override
	public User assignedRoleToUser(Long user_id, Long role_id) 
	{
	    User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
	    Role role = roleRepository.findById(role_id).orElseThrow(() -> new RuntimeException("Role not found"));
	    user.setAssignedRole(role);
	    return userRepository.save(user);
	}

	
	 @Override
	 @Transactional
	 public User updateUser(User user, String updatedBy) {
	     User existingUser = userRepository.findById(user.getId())
	             .orElseThrow(() -> new RuntimeException("User not found"));
	     existingUser.setUsername(user.getUsername());
	     existingUser.setAssignedRole(user.getAssignedRole());
	     existingUser.setUpdatedBy(updatedBy);
	     return userRepository.save(existingUser);
	    }
}
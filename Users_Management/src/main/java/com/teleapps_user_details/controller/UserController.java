package com.teleapps_user_details.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teleapps_user_details.domain.User;
import com.teleapps_user_details.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController 
{
	 @Autowired
	 private UserService userService;
	
	 
	 @PostMapping("/add")
	 public ResponseEntity<User> createUser(@RequestBody User user) 
	 {
	      User createdUser = userService.createUser(user);
	      return ResponseEntity.ok(createdUser);
	 }
	 
	 
	 @PutMapping("/update")
	 public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam String updatedBy) {
	     User updatedUser = userService.updateUser(user, updatedBy);
	     return ResponseEntity.ok(updatedUser);
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
	     User user = userService.getUserById(id);
	     Map<String, Object> response = new HashMap<>();
	     
	     if (user != null) {
	         response.put("message", "User retrieved successfully");
	         response.put("user", user);
	         return ResponseEntity.ok(response);
	     } else {
	         response.put("message", "User with ID " + id + " not found");
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	     }
	 }

	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteUserById(@PathVariable Long id) 
	 {
	     return userService.deleteUserById(id);
	 }
	 
	 
	 @PostMapping("/{user_id}/role/{role_id}")
	  public User assignedRoleToUser(@PathVariable Long user_id,@PathVariable Long role_id )
	  {
		 return userService.assignedRoleToUser(user_id,role_id);  	
	  }
	 
}
package com.teleapps_user_details.controller;



import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teleapps_user_details.domain.Role;
import com.teleapps_user_details.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        Map<String, Object> response = new HashMap<>();
        if (role != null) {
            response.put("message", "Role fetched successfully");
            response.put("role", role);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Role not found");
            return ResponseEntity.status(404).body(response);
        }
    }
    
    
    @PostMapping("/add")
	 public ResponseEntity<Role> createRole(@RequestBody Role role) 
	 {
	      Role createRole = roleService.createRole(role);
	      return ResponseEntity.ok(createRole);
	 }

    
    @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteRoleById(@PathVariable Long id) {
	     return roleService.deleteRoleById(id);
	 }
   
  @PostMapping("/{role_id}/feature/{feature_id}")
  public Role assignedFeatureToRole(@PathVariable Long role_id,@PathVariable Long feature_id )
 {
		return roleService.assignedFeatureToRole(role_id,feature_id);  	
  }
  
    
}

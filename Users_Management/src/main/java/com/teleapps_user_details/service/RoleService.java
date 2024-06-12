package com.teleapps_user_details.service;



import org.springframework.http.ResponseEntity;

import com.teleapps_user_details.domain.Role;




public interface RoleService {
	
	Role createRole(Role role);

    Role getRoleById(Long id);

    ResponseEntity<String> deleteRoleById(Long id);

	Role assignedFeatureToRole(Long role_id, Long feature_id);

}

package com.teleapps_user_details.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teleapps_user_details.domain.Feature;
import com.teleapps_user_details.domain.Role;
import com.teleapps_user_details.repository.FeatureRepository;
import com.teleapps_user_details.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService
{

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private FeatureRepository featureRepository;

	@Override
	@Transactional
	public Role createRole(Role role) 
	{
		return roleRepository.save(role);
	}
	

    @Override
    @Transactional
    public Role getRoleById(Long id) 
    {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElse(null);
    }


	@Override
	public ResponseEntity<String> deleteRoleById(Long id) {
	    Optional<Role> roleOptional = roleRepository.findById(id);
	    if (roleOptional.isPresent()) {
	        roleRepository.deleteById(id);
	        return ResponseEntity.ok("Role with ID " + id + " deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role with ID " + id + " not available");
	    }
	}
	
	@Override
	@Transactional
	public Role assignedFeatureToRole(Long roleId, Long featureId) {
	    Role role = roleRepository.findById(roleId)
	            .orElseThrow(() -> new RuntimeException("Role not found"));
	    Feature feature = featureRepository.findById(featureId)
	            .orElseThrow(() -> new RuntimeException("Feature not found"));
	    Set<Feature> assignedFeatures = role.getAssignedFeature();
	    assignedFeatures.add(feature);
	    role.setAssignedFeature(assignedFeatures);
	    return roleRepository.save(role);
	}


}




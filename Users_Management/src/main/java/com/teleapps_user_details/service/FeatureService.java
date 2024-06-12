package com.teleapps_user_details.service;

import org.springframework.http.ResponseEntity;
import com.teleapps_user_details.domain.Feature;


public interface FeatureService 
{
    Feature getFeatureById(Long id);
    
    Feature createFeature(Feature feature);

	ResponseEntity<String> deleteFeatureById(Long featureId);
	
}
package com.teleapps_user_details.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teleapps_user_details.domain.Feature;
import com.teleapps_user_details.service.FeatureService;


@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getFeatureById(@PathVariable Long id) {
        Feature feature = featureService.getFeatureById(id);
        Map<String, Object> response = new HashMap<>();
        if (feature != null) {
        	 response.put("message", "Feature fetched successfully");
        	 response.put("feature", feature);
            return ResponseEntity.ok(response);
        } else {
        	response.put("message", "Role not found");
            return ResponseEntity.status(404).body(response);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Feature> createFeature(@RequestBody Feature feature) {
        Feature createdFeature = featureService.createFeature(feature);
        return ResponseEntity.ok(createdFeature);
    }
    
    
    @DeleteMapping("/{featureId}")
    public ResponseEntity<String> deleteFeatureById(@PathVariable Long featureId) {
        ResponseEntity<String> response;
        try {
            response = featureService.deleteFeatureById(featureId);
        } catch (RuntimeException e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return response;
    }
        
 
}

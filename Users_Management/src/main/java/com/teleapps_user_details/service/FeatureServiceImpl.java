package com.teleapps_user_details.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.teleapps_user_details.domain.Feature;
import com.teleapps_user_details.repository.FeatureRepository;


import java.util.Optional;


@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;


    @Override
    @Transactional
    public Feature getFeatureById(Long id) 
    {
        Optional<Feature> featureOptional = featureRepository.findById(id);
        return featureOptional.orElse(null);
    }

	@Override
	@Transactional
	public Feature createFeature(Feature feature) {
		return featureRepository.save(feature);
	}

	
	@Override
	public ResponseEntity<String> deleteFeatureById(Long featureId) {
	    Optional<Feature> featureOptional = featureRepository.findById(featureId);
	    if (featureOptional.isPresent()) {
	        featureRepository.deleteById(featureId);
	        return ResponseEntity.ok("Feature with ID " + featureId + " deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feature with ID " + featureId + " not available");
	    }
	}

}


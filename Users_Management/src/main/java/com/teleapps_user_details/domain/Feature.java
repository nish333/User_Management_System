package com.teleapps_user_details.domain;

import java.util.Set;


import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Transactional
@Table(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String featureName;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedFeature")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set <Role> featureSet = new HashSet<>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}


	public Set<Role> getFeatureSet() {
		return featureSet;
	}

	public void setFeatureSet(Set<Role> featureSet) {
		this.featureSet = featureSet;
	}



}
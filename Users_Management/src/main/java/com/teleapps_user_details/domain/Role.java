package com.teleapps_user_details.domain;


import java.util.HashSet;
import java.util.Set;


import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Transactional
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;  


    @ManyToMany
    @JoinTable(
        name = "roles_features",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Feature> assignedFeature = new HashSet<>();        
    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	   
     public Set<Feature> getAssignedFeature() {
		return assignedFeature;
	}

	public void setAssignedFeature(Set<Feature> assignedFeature) {
		this.assignedFeature = assignedFeature;
	}

}
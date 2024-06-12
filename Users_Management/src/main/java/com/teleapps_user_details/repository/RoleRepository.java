package com.teleapps_user_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teleapps_user_details.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

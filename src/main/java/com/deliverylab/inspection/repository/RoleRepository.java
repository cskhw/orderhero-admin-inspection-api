package com.deliverylab.inspection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.deliverylab.inspection.models.ERole;
import com.deliverylab.inspection.models.Role;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}

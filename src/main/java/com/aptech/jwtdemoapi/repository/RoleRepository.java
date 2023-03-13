package com.aptech.jwtdemoapi.repository;

import com.aptech.jwtdemoapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}

package com.aptech.jwtdemoapi.Repository;

import com.aptech.jwtdemoapi.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}

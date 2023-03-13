package com.aptech.jwtdemoapi.service;

import com.aptech.jwtdemoapi.entity.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {
    Role save(Role role);

    Optional<Role> getById(int id);

    void remove(int id);

    Set<Role> getAll();
}

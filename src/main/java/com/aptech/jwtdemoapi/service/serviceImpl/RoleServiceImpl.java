package com.aptech.jwtdemoapi.service.serviceImpl;

import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.repository.RoleRepository;
import com.aptech.jwtdemoapi.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void remove(int id) {
    repository.deleteById(id);
    }

    @Override
    public Set<Role> getAll() {
        return new HashSet<>(repository.findAll());
    }
}

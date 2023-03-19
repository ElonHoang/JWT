package com.aptech.jwtdemoapi.service.serviceImpl;

import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.entity.User_Role;
import com.aptech.jwtdemoapi.repository.UserRoleRepository;
import com.aptech.jwtdemoapi.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    final UserRoleRepository repository;

    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User_Role> getAll() {
        return repository.findAll();
    }

    @Override
    public User_Role save(User_Role ur) {
        return repository.save(ur);
    }

    @Override
    public void delete(int roleId, int userId) {
        repository.deleteUserRoleByRoleId_UserId(roleId, userId);
    }

    @Override
    public Set<Role> getRoleByUserId(int userId) {
        return repository.getRoleByUserId(userId);
    }
}

package com.aptech.jwtdemoapi.service;

import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.entity.User_Role;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    public List<User_Role> getAll();
    public User_Role save(User_Role ur);

    public void delete(int roleId, int userId);

    public Set<Role> getRoleByUserId(int userId);


}

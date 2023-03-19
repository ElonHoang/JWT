package com.aptech.jwtdemoapi.repository;

import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.entity.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRoleRepository extends JpaRepository<User_Role,Integer> {
    @Query("DELETE FROM User_Role ur WHERE ur.id.roleId = ?1 AND ur.id.userId = ?2")
    public void deleteUserRoleByRoleId_UserId(int roleId, int userId);

    @Query("SELECT r FROM User_Role ur JOIN Role r on ur.role.id = r.id WHERE ur.user.id = ?1")
    public Set<Role> getRoleByUserId(int userId);
}

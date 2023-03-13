package com.aptech.jwtdemoapi.Service;

import com.aptech.jwtdemoapi.Entity.User;

import java.util.Set;

public interface UserService {
    User add(User user);
    Set<User> getAll();
}

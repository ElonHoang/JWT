package com.aptech.jwtdemoapi.service;

import com.aptech.jwtdemoapi.entity.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    User save(User user);

    Set<User> getAll();

    Optional<User> getUserById(int id);

    void remove(int id);



}

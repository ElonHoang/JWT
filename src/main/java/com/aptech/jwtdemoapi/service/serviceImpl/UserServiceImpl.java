package com.aptech.jwtdemoapi.service.serviceImpl;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.repository.UserRepository;
import com.aptech.jwtdemoapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Set<User> getAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Optional<User> getByUserName(String name) {
        return repository.findById(name);
    }

    @Override
    public void remove(String userName) {
    repository.deleteById(userName);
    }
}

package com.aptech.jwtdemoapi.controller;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.jwt.TokenJWTUtils;
import com.aptech.jwtdemoapi.service.UserService;
import com.aptech.jwtdemoapi.service.serviceImpl.UserServiceImpl;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    PasswordEncoder encoder;
    final UserService service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/list")
    public ResponseEntity<Set<User>> getAll(){
        User u = new User();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        u.setUserName("HoangA5");
        u.setPassword(encoder.encode("123567"));
        u.setEmail("Axxx@gmail.com");
        service.save(u);
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@Valid @RequestBody User user){
        User u = service.save(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id , @RequestBody User user){
        return new ResponseEntity<>(updateUserFromField(id, user), HttpStatus.GONE);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getUserById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        service.remove(id);
    }

    public User updateUserFromField(int id, User user){
        User u = service.getUserById(id).get();
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        service.save(u);
        return u;
    }

}

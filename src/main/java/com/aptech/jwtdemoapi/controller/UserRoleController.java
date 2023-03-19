package com.aptech.jwtdemoapi.controller;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.entity.User_Role;
import com.aptech.jwtdemoapi.service.UserRoleService;
import com.aptech.jwtdemoapi.service.serviceImpl.UserRoleServiceImpl;
//import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ur")
public class UserRoleController {
    final UserRoleService service;

    public UserRoleController(UserRoleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<User_Role> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public User_Role add(@Valid @RequestBody User_Role ur){
        return service.save(ur);
    }

}

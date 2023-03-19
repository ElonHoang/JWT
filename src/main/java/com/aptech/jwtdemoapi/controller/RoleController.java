package com.aptech.jwtdemoapi.controller;

import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.service.RoleService;
import com.aptech.jwtdemoapi.service.serviceImpl.RoleServiceImpl;
//import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController {
    final RoleService service;

    public RoleController(RoleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<Set<Role>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> add(@Valid @RequestBody Role role){
        Role r = service.save(role);
        return new ResponseEntity<>(r,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> update(@PathVariable("id")int id, @RequestBody Role role){
        return new ResponseEntity<>(updateRoleFromField(id,role),HttpStatus.GONE);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Role> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        service.remove(id);
    }

    public Role updateRoleFromField(int id, Role role){
        Role r = service.getById(id).get();
        r.setRoleName(role.getRoleName());
        service.save(r);
        return r;
    }
}

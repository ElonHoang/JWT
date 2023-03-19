package com.aptech.jwtdemoapi.controller;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.jwt.TokenJWTUtils;
//import jakarta.validation.Valid;
import com.aptech.jwtdemoapi.service.serviceImpl.CustomerUserDetail;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUserName(),
                            user.getPassword()
                    )
            );
            CustomerUserDetail userDetail = (CustomerUserDetail) authentication.getPrincipal();
            System.out.println(userDetail.toString());
            String token = TokenJWTUtils.generateToken(userDetail.getUser());
            return ResponseEntity.ok().body(token);
        }catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

    @GetMapping("/test")
    public String test(){
        return "OKELA !";
    }
}

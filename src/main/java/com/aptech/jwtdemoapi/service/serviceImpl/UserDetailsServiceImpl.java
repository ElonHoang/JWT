package com.aptech.jwtdemoapi.service.serviceImpl;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
     UserRepository repository;


    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("UserName Not Found !");
        }
        return new CustomerUserDetail(user);
    }

}

package com.aptech.jwtdemoapi.service.serviceImpl;

import com.aptech.jwtdemoapi.entity.CourseRatingKey;
import com.aptech.jwtdemoapi.entity.Role;
import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.entity.User_Role;
import com.aptech.jwtdemoapi.repository.RoleRepository;
import com.aptech.jwtdemoapi.repository.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomerUserDetail implements UserDetails {

    User u;
    UserRoleRepository ur;

    public CustomerUserDetail() {

    }

    public CustomerUserDetail(User u) {
        this.u = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Role> roleSet = ur.getRoleByUserId(u.getId());
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for(Role role : roleSet){
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return authorities;
        return null;
    }

    public User getUser() {
        return u;
    }

    public void setUser(User u) {
        this.u = u;
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

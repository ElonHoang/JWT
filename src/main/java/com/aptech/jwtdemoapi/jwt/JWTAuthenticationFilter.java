package com.aptech.jwtdemoapi.jwt;

import com.aptech.jwtdemoapi.entity.User;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import com.aptech.jwtdemoapi.service.serviceImpl.CustomerUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    TokenJWTUtils tokenJWTUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!hasAuthorizationBearer(request)){
            filterChain.doFilter(request,response);
            return;
        }
        String token = getAccessToken(request);
        if(!TokenJWTUtils.validateToken(token)){
            filterChain.doFilter(request,response);
            return;
        }
        setAuthenticationContext(token,request);
        filterChain.doFilter(request,response);//
    }

    private  boolean hasAuthorizationBearer(HttpServletRequest request){
        String header = request.getHeader(TokenJWTUtils.HEADER_STRING);
        if(ObjectUtils.isEmpty(header) || !header.startsWith(TokenJWTUtils.TOKEN_PREFIX)){
            return false;
        }
        return true;
    }

    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader(TokenJWTUtils.HEADER_STRING);
        String token = header.split(" ")[1].trim();
        System.out.println("Token: "+token);
        return token; //
    }
    private void setAuthenticationContext(String token, HttpServletRequest request){
        UserDetails userDetails = getUserDetails(token);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,null);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);//
    }

    private UserDetails getUserDetails(String token){
        CustomerUserDetail userDetails = new CustomerUserDetail();
        String[] jwtSubject = tokenJWTUtils.getSubject(token).split(",");
        User u = new User();
        u.setId(Integer.valueOf(jwtSubject[0]));
        u.setUserName(jwtSubject[1]);
        userDetails.setUser(u);
        return userDetails;
    }
}

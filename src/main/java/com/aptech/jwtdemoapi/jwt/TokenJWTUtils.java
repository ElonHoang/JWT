package com.aptech.jwtdemoapi.jwt;

import com.aptech.jwtdemoapi.entity.User;
import com.aptech.jwtdemoapi.service.serviceImpl.CustomerUserDetail;
import io.jsonwebtoken.*;
//import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.util.Collections.emptyList;
@Slf4j
@Component
public class TokenJWTUtils {
    static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
    static final String SECRET_KEY = "jwtKey";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static String generateToken(User user){
        long expirationTime = EXPIRATION_TIME;
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUserName()))
                .setIssuer("com.aptech.jwtdemoapi")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }
    private Claims parseClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
    public static boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        }catch(MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch(ExpiredJwtException ex){
            log.error("Expired JWT Token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}

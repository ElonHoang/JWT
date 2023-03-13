package com.aptech.jwtdemoapi.Repository;

import com.aptech.jwtdemoapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}

package com.aptech.jwtdemoapi.entity;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tblUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @NotBlank
    @Column(name = "userName",length = 50)
    private String userName;

    @Column(name = "email",length = 50)
    @NotBlank
    private String email;

    @Column(name = "password",length = 200)
    @NotBlank
    private String password;




}

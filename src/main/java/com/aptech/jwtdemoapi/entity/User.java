package com.aptech.jwtdemoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tblUser")
public class User {
    @Id
    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotBlank
    private String password;

}

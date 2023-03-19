package com.aptech.jwtdemoapi.entity;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "tblRole")
@Entity
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roleName",length = 50)
    @NotBlank
    private String roleName;


}

package com.aptech.jwtdemoapi.entity;

//import jakarta.persistence.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tblUser_Role")
public class User_Role {
    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

}

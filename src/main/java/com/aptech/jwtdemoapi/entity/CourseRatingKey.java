package com.aptech.jwtdemoapi.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CourseRatingKey implements Serializable {
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "user_id")
    private int userId;
}

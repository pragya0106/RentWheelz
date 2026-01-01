package com.gl.RentWheelz.model;
/*
create a spring data jpa entity class User with the following fields:
userName (String) - required,
userEmail (String)  - required and unique,
userPassword (String) - required,
proofId (String)  - required
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String proofId;
}



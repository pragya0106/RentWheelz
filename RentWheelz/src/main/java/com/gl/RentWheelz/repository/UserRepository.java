package com.gl.RentWheelz.repository;

import com.gl.RentWheelz.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserEmail(String userEmail);

    Users findByUserEmailAndUserPassword(String userEmail, String userPassword);
}

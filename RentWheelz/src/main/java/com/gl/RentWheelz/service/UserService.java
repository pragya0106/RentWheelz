package com.gl.RentWheelz.service;

import com.gl.RentWheelz.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.RentWheelz.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // create a method to save a user
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    // create a method to find a user by email
    public Users findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    // create a method to find all users
    public Iterable<Users> findAllUsers() {
        return userRepository.findAll();
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findByUserEmailAndUserPassword(String userEmail, String userPassword) {
        return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
    }

    public Optional<Users> findId(Long userId) {
        return userRepository.findById(userId);
    }
}

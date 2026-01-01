package com.gl.RentWheelz.controller;

import com.gl.RentWheelz.dto.LoginRequest;
import com.gl.RentWheelz.dto.LoginResponse;
import com.gl.RentWheelz.dto.RegistrationResponse;
import com.gl.RentWheelz.model.Users;
import com.gl.RentWheelz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // auto wire the UserService class
    @Autowired
    private UserService userService;

    // create a @PostMapping to save a user
    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody Users user) {
        System.out.println("user = " + user);
        return userService.saveUser(user);
    }

    // create a method @GetMapping to find a user by email
    @GetMapping("/findByUserEmail")
    public Users findByUserEmail(String userEmail) {
        return userService.findByUserEmail(userEmail);
    }

    // create a method @GetMapping to find all users
    @GetMapping("/findAllUsers")
    public Iterable<Users> findAllUsers() {
        return userService.findAllUsers();
    }

    // create a method @PostMapping to register a user
    @PostMapping("/register")
    public RegistrationResponse registerUser(@RequestBody Users user) {
        Users users = userService.saveUser(user);
        // create a response using RegistrationResponse
        RegistrationResponse response = new RegistrationResponse();
        response.setStatus("Success");
        response.setMessage("User registered successfully");
        return response;
    }

    // create a method @PostMapping to login a user
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest user) {
        Users users = userService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
        // create a response using LoginResponse
        LoginResponse response = new LoginResponse();
        if (users != null) {
            response.setStatus("Success");
            response.setMessage("User logged in successfully");
            LoginResponse.UserData data = new LoginResponse.UserData();
            data.setUserName(users.getUserName());
            data.setUserEmail(users.getUserEmail());
            data.setProofId(users.getProofId());
            response.setData(data);
        } else {
            response.setStatus("Failure");
            response.setMessage("User not found");
        }
        return response;
    }
}

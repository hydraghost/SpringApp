package com.telusko.jobapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.jobapp.model.User;
import com.telusko.jobapp.service.JwtService;
import com.telusko.jobapp.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    
    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User user1=service.saveUser(user);
        return ResponseEntity.ok("User Registered Successfully " + user1);
    }

    @PostMapping("/login")
    public ResponseEntity<String> LoginUser(@RequestBody User user){

        User user1=service.fetchUserByUsername(user.getUsername());
        if(user1==null || !encoder.matches(user.getPassword(), user1.getPassword())) {
                return ResponseEntity.status(401).body("Invalid Credentials");
        }
        String jwToken=jwtService.generateToken(user.getUsername());
        return ResponseEntity.ok("Login Successful " + user1 + " Token: " + jwToken) ;
       
    }

}

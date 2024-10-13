package com.telusko.jobapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.jobapp.model.User;
import com.telusko.jobapp.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public User saveUser(User user){
        return repo.save(user);
        
    }
    public User fetchUserByUsernameAndPassword(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
    public User fetchUserByUsername(String username) {
        return repo.findByUsername(username);
    }
}

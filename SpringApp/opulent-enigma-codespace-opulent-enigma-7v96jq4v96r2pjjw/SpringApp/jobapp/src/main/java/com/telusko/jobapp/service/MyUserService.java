package com.telusko.jobapp.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.jobapp.model.JobPost;
import com.telusko.jobapp.model.User;
import com.telusko.jobapp.model.UserPricipal;
import com.telusko.jobapp.repo.UserRepo;

@Service
public class MyUserService implements UserDetailsService{
    
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);
        System.out.println("from MyUserService");
        if(user==null) {
            System.out.println(username+" not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPricipal(user);
    }

    

}

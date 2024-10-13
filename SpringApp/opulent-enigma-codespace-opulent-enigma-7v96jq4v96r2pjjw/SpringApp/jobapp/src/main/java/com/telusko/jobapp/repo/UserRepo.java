package com.telusko.jobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.jobapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}

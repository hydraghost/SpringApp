package com.telusko.jobapp.model;

import java.util.*;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
@Component
@Entity
public class User {
    @Id
    private String username;
    private String password;
}


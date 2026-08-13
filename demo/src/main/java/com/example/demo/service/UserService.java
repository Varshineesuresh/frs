package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all registered users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
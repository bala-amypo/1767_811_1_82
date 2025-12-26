package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserAccountService;

import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository repository;

    public UserAccountServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}

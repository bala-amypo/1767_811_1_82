package com.example.demo.service;

import com.example.demo.model.User;
import java.util.Optional;

public interface UserAccountService {

    User registerUser(User user);

    Optional<User> findByUsername(String username);
}

package com.example.demo.service;

import com.example.demo.model.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    UserAccount saveUser(UserAccount userAccount);
    List<UserAccount> getAllUsers();

    Optional<UserAccount> authenticateUser(String username, String password);
}

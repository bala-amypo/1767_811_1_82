package com.example.demo.service;

import com.example.demo.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount saveUser(UserAccount userAccount);

    UserAccount authenticateUser(String username, String password);

    List<UserAccount> getAllUsers();
}

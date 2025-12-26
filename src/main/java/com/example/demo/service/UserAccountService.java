package com.example.demo.service;

import com.example.demo.model.UserAccount;

public interface UserAccountService {

    UserAccount registerUser(UserAccount user);

    UserAccount getUserByUsername(String username);

    UserAccount getUserByEmail(String email);
}

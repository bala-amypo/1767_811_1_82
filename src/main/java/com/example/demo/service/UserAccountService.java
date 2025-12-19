package com.example.demo.service;

import com.example.demo.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount saveUser(UserAccount user);

    List<UserAccount> getAllUsers();
}

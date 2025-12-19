package com.example.demo.service;

import com.example.demo.model.UserAccount;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    String login(String email, String password);
}

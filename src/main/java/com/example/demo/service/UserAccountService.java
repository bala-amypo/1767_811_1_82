package com.example.demo.service;

import com.example.demo.model.UserAccount;
import java.util.Optional;

public interface UserAccountService {
    UserAccount saveUser(UserAccount user);
    Optional<UserAccount> getUserByUsername(String username);
}

package com.example.demo.service;

import com.example.demo.model.UserAccount;
import java.util.Optional;

public interface UserAccountService {
    UserAccount registerUser(UserAccount user);
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findById(Long id);
}

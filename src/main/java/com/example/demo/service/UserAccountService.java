package com.example.demo.service;

import com.example.demo.model.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> findById(Long id);
    List<UserAccount> getAllUsers();
    UserAccount createUser(UserAccount user);
    UserAccount updateUser(Long id, UserAccount updatedUser);
}

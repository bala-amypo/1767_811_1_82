package com.example.demo.service.impl;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount saveUser(UserAccount userAccount) {
        return userRepo.save(userAccount);
    }

    @Override
    public UserAccount authenticateUser(String username, String password) {
        Optional<UserAccount> user = userRepo.findByUsernameAndPassword(username, password);
        return user.orElse(null); // can throw exception if preferred
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}

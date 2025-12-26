package com.example.demo.service.impl;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserAccount updateUser(UserAccount updatedUser) {
        UserAccount user = userRepo.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(updatedUser.getEmail());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setRole(updatedUser.getRole());
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}

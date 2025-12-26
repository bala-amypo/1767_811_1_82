package com.example.demo.service.impl;

import com.example.demo.model.UserAccount;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount register(RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // For real app, encode password!
        return userRepo.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        UserAccount user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(!user.getPassword().equals(request.getPassword()))
            throw new RuntimeException("Invalid password");

        return new AuthResponse("FAKE-JWT-TOKEN"); // Simulated JWT for testing
    }
}

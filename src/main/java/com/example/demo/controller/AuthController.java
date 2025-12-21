package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    // POST: Register a new user
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount userAccount) {
        return userService.saveUser(userAccount);
    }

    // POST: Authenticate (login) a user
    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount userAccount) {
        Optional<UserAccount> userOpt = userService.authenticateUser(
                userAccount.getUsername(),
                userAccount.getPasswordHash() // using passwordHash from entity
        );
        return userOpt.orElse(null); // returns null if authentication fails
    }
}

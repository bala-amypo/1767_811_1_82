package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount userAccount) {
        return userService.saveUser(userAccount);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount userAccount) {
        Optional<UserAccount> userOpt = userService.authenticateUser(
                userAccount.getUsername(), 
                userAccount.getPasswordHash()  // make sure your entity has getPasswordHash()
        );

        return userOpt.orElse(null); // or throw exception if user not found
    }

    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}

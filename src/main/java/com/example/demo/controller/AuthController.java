package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }
}

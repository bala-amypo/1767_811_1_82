// package com.example.demo.controller;

// import com.example.demo.model.UserAccount;
// import com.example.demo.service.UserAccountService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserAccountService service;

//     public AuthController(UserAccountService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public UserAccount register(@RequestBody UserAccount user) {
//         return service.registerUser(user);
//     }

//     @PostMapping("/login")
//     public String login() {
//         return "Login successful";
//     }
// }





   

        package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserAccountService service;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserAccountService service,
                          AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.registerUser(user);
    }

    // ✅ LOGIN (NO JWT, FIXED)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccount loginRequest) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),        // OR username if you use that
                        loginRequest.getPasswordHash()  // ✅ correct field
                );

        authenticationManager.authenticate(authToken);

        return ResponseEntity.ok("Login successful");
    }
}


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

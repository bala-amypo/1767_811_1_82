

package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.config.JwtTokenProvider;

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
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserAccountService service,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.registerUser(user);
    }

    // ✅ LOGIN (JWT based – same logic as above)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserAccount loginRequest) {

        // authenticate username & password
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );

        authenticationManager.authenticate(authToken);

        // fetch user
        UserAccount user = service.findByUsername(loginRequest.getUsername());

        // generate JWT
        String token = jwtTokenProvider.generateToken(authToken, user);

        return ResponseEntity.ok(token);
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

package com.example.demo.dto;

public class AuthResponse {
    private String token;
    private String tokenType;

    // No-args constructor
    public AuthResponse() {}

    // All-args constructor
    public AuthResponse(String token, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}

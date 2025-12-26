package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    @ElementCollection
    private Set<String> role;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== getters & setters REQUIRED by controllers/security =====

    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Set<String> getRole() { return role; }
    public void setRole(Set<String> role) { this.role = role; }
}

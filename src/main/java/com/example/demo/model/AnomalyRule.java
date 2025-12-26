package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private Boolean active = true;

    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public Boolean getActive() { return active; }
}

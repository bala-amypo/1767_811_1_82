package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hours, int tasks, int meetings) {
        return (hours * 10) + (tasks * 5) + (meetings * 2);
    }
}

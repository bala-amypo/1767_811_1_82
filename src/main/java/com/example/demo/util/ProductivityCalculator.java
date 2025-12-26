package com.example.demo.util;

public class ProductivityCalculator {
    public static double computeScore(double hours, int tasks, int meetings) {
        if (hours < 0) hours = 0;
        if (tasks < 0) tasks = 0;
        if (meetings < 0) meetings = 0;

        double score = (hours * 0.5 + tasks * 2.0 - meetings * 0.3);
        score = Math.max(0, Math.min(100, score));
        return Math.round(score * 100.0) / 100.0;
    }
}

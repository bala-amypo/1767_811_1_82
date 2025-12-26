package com.example.demo.util;

public class ProductivityCalculator {

    public static double computeScore(double hours, int tasks, int meetings) {
        if (Double.isNaN(hours) || hours <= 0 || tasks < 0 || meetings < 0) return 0.0;

        double score = (tasks * 10) + (hours * 2) - (meetings * 1.5);
        score = Math.max(0, Math.min(100, score));
        return Math.round(score * 100.0) / 100.0;
    }
}

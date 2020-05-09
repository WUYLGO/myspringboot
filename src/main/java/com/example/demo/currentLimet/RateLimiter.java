package com.example.demo.currentLimet;

public interface RateLimiter {

    boolean isOverLimit();

    long currentQPS();

    boolean visit();
}
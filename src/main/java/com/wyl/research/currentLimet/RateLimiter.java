package com.wyl.research.currentLimet;

public interface RateLimiter {

    boolean isOverLimit();

    long currentQPS();

    boolean visit();
}
package com.company.SecondLesson.implementation;

import com.company.SecondLesson.interfaces.RateLimitedPrinter;

public class RateLimitedPrinterImpl implements RateLimitedPrinter {
    private final long interval;
    private long lastInputTime;


    public RateLimitedPrinterImpl(int interval){
        this.interval = interval;
    }

    public void print(String message){
        long currentTime = System.currentTimeMillis();
        if ((currentTime - this.lastInputTime) > interval){
            System.out.println(message);
            this.lastInputTime = System.currentTimeMillis();
        }


    }
}

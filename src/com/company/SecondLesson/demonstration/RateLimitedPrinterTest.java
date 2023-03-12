package com.company.SecondLesson.demonstration;

import com.company.SecondLesson.realisation.RateLimitedPrinterImpl;

public class RateLimitedPrinterTest {
    public static void main(String[] args) {
        RateLimitedPrinterImpl rateLimitedPrinterImpl = new RateLimitedPrinterImpl(1000);
        for (int i = 0; i < 1_000_000_000; i++) {
            rateLimitedPrinterImpl.print(String.valueOf(i));
        }
    }
}

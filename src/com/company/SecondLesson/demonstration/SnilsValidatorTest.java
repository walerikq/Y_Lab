package com.company.SecondLesson.demonstration;

import com.company.SecondLesson.realisation.SnilsValidatorImpl;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        SnilsValidatorImpl snilsValidator = new SnilsValidatorImpl();

       System.out.println( snilsValidator.validate("01468870570"));
       System.out.println( snilsValidator.validate("90114404441"));
    }
}

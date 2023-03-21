package com.company.SecondLesson.implementation;

import com.company.SecondLesson.interfaces.SnilsValidator;

import java.util.regex.Pattern;

public class SnilsValidatorImpl implements SnilsValidator {

    @Override
    public boolean validate(String snils) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        if (!Pattern.matches(String.valueOf(pattern), snils)) {
            return false;
        }

        char[] snilsNumbers = snils.toCharArray();
        int reverseIndex = 9;
        int resultSum = 0;
        int controlNum;
        int controlSum;
        for (int i = 0; i < 9; i++) {
            resultSum += Character.getNumericValue(snilsNumbers[i]) * reverseIndex;
            reverseIndex--;
        }
        if (resultSum < 100) {
            controlNum = resultSum;
        } else if (resultSum == 100) {
            controlNum = 0;
        } else {
            if (resultSum % 101 == 100) {
                controlNum = 0;
            } else {
                controlNum = resultSum % 101;
            }
        }
        controlSum = Integer.parseInt(snilsNumbers[9] + "" + snilsNumbers[10]);
        if (controlSum == controlNum) {
            return true;
        } else {
            return false;
        }
    }
}

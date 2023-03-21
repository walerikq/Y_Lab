package com.company.ThirdLesson.PasswordValidatorPack;

import com.company.ThirdLesson.PasswordValidatorPack.exception.WrongLoginException;
import com.company.ThirdLesson.PasswordValidatorPack.exception.WrongPasswordException;
import com.company.ThirdLesson.PasswordValidatorPack.PasswordValidator;

public class PasswordValidatorDemo {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        System.out.println(PasswordValidator.validator("fghjklGHJ","2222222","2222222"));

    }
}

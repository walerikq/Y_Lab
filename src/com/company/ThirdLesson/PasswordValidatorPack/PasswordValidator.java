package com.company.ThirdLesson.PasswordValidatorPack;

import com.company.ThirdLesson.PasswordValidatorPack.exception.WrongLoginException;
import com.company.ThirdLesson.PasswordValidatorPack.exception.WrongPasswordException;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern loginAndPasswordPattern = Pattern.compile("\\w+");

    public static boolean validator(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (!Pattern.matches(String.valueOf(loginAndPasswordPattern), login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }
        if (!Pattern.matches(String.valueOf(loginAndPasswordPattern), password)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
        if (login.length() >= 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль слишком длинный");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение не совпадают");
        }

        return true;

    }
}

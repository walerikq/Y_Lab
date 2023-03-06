package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int number = new Random().nextInt(99) + 1;
        try(Scanner scanner = new Scanner(System.in)){
            int maxAttempts = 10;
            System.out.println("Я загадал число. У тебя " + maxAttempts +
                    " попыток угадать.");
            for (int i = 1; i <= maxAttempts; i++) {
                int userNum = scanner.nextInt();
                if (userNum > number){
                    System.out.println("Мое число меньше! У тебя осталось "+ (maxAttempts - i) +" попыток");
                } else if (userNum < number){
                    System.out.println("Мое число больше! У тебя осталось " + (maxAttempts - i) + " попыток");
                }else if(userNum == number){
                    System.out.println("Ты угадал с "+ i +" попытки");
                    break;
                }
                if (i == 10){
                    System.out.println("Ты не угадал.");
                }
            }
        }

    }
}

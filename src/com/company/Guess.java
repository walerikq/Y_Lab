package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int number = new Random().nextInt(99) + 1;
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println(number);

            int maxAttempts = 10;
            System.out.println("� ������� �����. � ���� " + maxAttempts +
                    " ������� �������.");
            for (int i = 1; i <= maxAttempts; i++) {
                int userNum = scanner.nextInt();
                if (userNum > number){
                    System.out.println("��� ����� ������! � ���� �������� "+ (maxAttempts - i) +" �������");
                } else if (userNum < number){
                    System.out.println("��� ����� ������! � ���� �������� " + (maxAttempts - i) + " �������");
                }else if(userNum == number){
                    System.out.println("�� ������ � "+ i +" �������");
                    break;
                }
                if (i == 10){
                    System.out.println("�� �� ������.");
                }
            }
        }

    }
}

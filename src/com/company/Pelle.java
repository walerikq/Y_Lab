package com.company;

import java.util.Scanner;

public class Pelle {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("¬ведите число n (0 <= n <= 30): ");

            while(true){

                int n = sc.nextInt();
                int p1 = 0, p2 = 1, p3 = 0;

                if (n <= 1) {
                    System.out.println(n);
                    break;
                } else if (n > 30 || n < 0) {
                    System.out.println("¬ведите число в указанном диапазоне - (0 <= n <= 30)");
                    continue;
                } else {
                    for (int i = 2; i <= n; i++) {
                        p3 = 2 * p2 + p1;
                        p1 = p2;
                        p2 = p3;
                    }
                    System.out.println("„исло ѕелл€ P(n) = " + p3);
                    break;
                }

            }
        }
    }
}

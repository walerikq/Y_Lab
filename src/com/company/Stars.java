package com.company;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
            stars();
    }

    public static void  stars(){
        try(Scanner scanner = new Scanner(System.in)){
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            char c = scanner.next().charAt(0);

            // Print the shape
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        }
    }
}

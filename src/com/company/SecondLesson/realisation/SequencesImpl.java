package com.company.SecondLesson.realisation;

import com.company.SecondLesson.interfaces.Sequences;

public class SequencesImpl implements Sequences {

    @Override
    public void firstSequences(int n) {
        for (int i = 1; i <= n;i++) {
            System.out.print(i*2 + ", ");
        }
        System.out.println();
    }

    @Override
    public void secondSequences(int n) {
        for (int i = 1; i <= n;i++) {
            System.out.print(i*2-1 + ", ");
        }
        System.out.println();


    }

    @Override
    public void thirdSequences(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((int)Math.pow(i,2) + ", ");
        }
        System.out.println();


    }

    @Override
    public void fourthSequences(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((long)Math.pow(i,3) + ", ");
        }
        System.out.println();


    }

    @Override
    public void fifthSequences(int n) {
        short num = 1;
        for (int i = 0; i <= n; i++) {
            System.out.print(num + ", ");
            num = (short) -num;
        }
        System.out.println();


    }

    @Override
    public void sixthSequences(int n) {
        int num;
        for (int i = 1; i <= n; i++) {
            num = i;
            if (num % 2 == 0){
                num = -num;
            }
            System.out.print(num + ", ");
        }
        System.out.println();


    }

    @Override
    public void seventhSequences(int n) {
        long num;
        for (int i = 1; i <= n; i++) {
            num = (long) Math.pow(i,2);
            if (num % 2 == 0){
                num = -num;
            }
            System.out.print(num + ", ");
        }
        System.out.println();

    }

    @Override
    public void eightSequences(int n) {
        int count = 1;
        int zeroNum = 0;
        long resultNum;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0){
                resultNum = zeroNum;
                System.out.print(resultNum +  ", ");
            }else {
                resultNum = count;
                System.out.print(resultNum + ", ");
                count++;
            }
        }
        System.out.println();

    }

    @Override
    public void ninthSequences(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;

            System.out.print(result + ", ");
        }
        System.out.println();

    }

    @Override
    public void tenthSequences(int n) {
        int previousNumber = 0;
        int resultNumber = 1;
        System.out.print(1 + ", ");
        for (int i = 0; i <= n; i++) {
            resultNumber += previousNumber;
            previousNumber = resultNumber-previousNumber;

            if (i == n){
                System.out.print(resultNumber);
                continue;
            }
            System.out.print(resultNumber + ", ");

        }
    }
}

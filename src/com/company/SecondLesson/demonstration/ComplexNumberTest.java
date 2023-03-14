package com.company.SecondLesson.demonstration;

import com.company.SecondLesson.implementation.ComplexNumberImpl;

public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumberImpl a = new ComplexNumberImpl(2.0, 3.0);
        ComplexNumberImpl b = new ComplexNumberImpl(-1.0, 4.0);

        ComplexNumberImpl c = a.sum(b);
        System.out.println("a + b = " + c);

        ComplexNumberImpl d = a.subtract(b);
        System.out.println("a - b = " + d);

        ComplexNumberImpl e = a.multiply(b);
        System.out.println("a * b = " + e);

        double moduloA = a.getModulo();
        System.out.println("|a| = " + moduloA);

        double moduloB = b.getModulo();
        System.out.println("|b| = " + moduloB);
    }
}

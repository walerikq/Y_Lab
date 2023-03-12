package com.company.SecondLesson.realisation;

import com.company.SecondLesson.interfaces.ComplexNumber;

public class ComplexNumberImpl implements  ComplexNumber{
    private double realPart;
    private double imaginaryPart;

    public ComplexNumberImpl(double realPart) {
        this(realPart, 0.0);
    }

    public ComplexNumberImpl(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumberImpl sum(ComplexNumberImpl other) {
        double newRealPart = this.realPart + other.realPart;
        double newImaginaryPart = this.imaginaryPart + other.imaginaryPart;
        return new ComplexNumberImpl(newRealPart, newImaginaryPart);
    }

    public ComplexNumberImpl subtract(ComplexNumberImpl other) {
        double newRealPart = this.realPart - other.realPart;
        double newImaginaryPart = this.imaginaryPart - other.imaginaryPart;
        return new ComplexNumberImpl(newRealPart, newImaginaryPart);
    }

    public ComplexNumberImpl multiply(ComplexNumberImpl other) {
        double newRealPart = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
        double newImaginaryPart = this.realPart * other.imaginaryPart + this.imaginaryPart * other.realPart;
        return new ComplexNumberImpl(newRealPart, newImaginaryPart);
    }

    public double getModulo() {
        return Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2));
    }

    @Override
    public String toString() {
        if (this.imaginaryPart < 0) {
            return String.format("%.2f - %.2fi", this.realPart, Math.abs(this.imaginaryPart));
        } else {
            return String.format("%.2f + %.2fi", this.realPart, this.imaginaryPart);
        }
    }
}

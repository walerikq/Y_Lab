package com.company.SecondLesson.interfaces;

import com.company.SecondLesson.realisation.ComplexNumberImpl;

public interface ComplexNumber {

    ComplexNumberImpl sum(ComplexNumberImpl other);

    ComplexNumberImpl subtract(ComplexNumberImpl other);

    ComplexNumberImpl multiply(ComplexNumberImpl other);

    double getModulo();


}

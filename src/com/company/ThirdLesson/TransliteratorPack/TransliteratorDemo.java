package com.company.ThirdLesson.TransliteratorPack;

import com.company.ThirdLesson.TransliteratorPack.TransliteratorImpl;

public class TransliteratorDemo {
    public static void main(String[] args) {
        TransliteratorImpl transliterator = new TransliteratorImpl();
        System.out.println(transliterator.transliterate("HELLO! ПРИВЕТ, земляне! Go boy!"));
    }

}

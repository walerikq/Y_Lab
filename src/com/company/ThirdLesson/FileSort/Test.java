package com.company.ThirdLesson.FileSort;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("data.txt", 100);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new File("sorted.txt"); // create a new file to save the sorted output
        new Sorter().sortFile(dataFile, sortedFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}

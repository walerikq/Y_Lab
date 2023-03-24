package com.company.ThirdLesson.FileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    private static final int DEFAULT_PART_SIZE = 100_000_000;

    public void sortFile(File dataFile, File sortedFile) throws IOException {
        sortFile(dataFile, sortedFile, DEFAULT_PART_SIZE);
    }

    public void sortFile(File dataFile, File sortedFile, int partSize) throws IOException {
        List<File> sortedParts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(dataFile))) {
            long[] part = new long[partSize];
            int i = 0;
            while (scanner.hasNextLong()) {
                part[i] = scanner.nextLong();
                i++;
                if (i == partSize) {
                    Arrays.sort(part);
                    sortedParts.add(writePartToFile(part));
                    part = new long[partSize];
                    i = 0;
                }
            }
            if (i > 0) {
                Arrays.sort(part, 0, i);
                sortedParts.add(writePartToFile(Arrays.copyOf(part, i)));
            }
        }

        mergeSortedParts(sortedParts, sortedFile);
    }

    private File writePartToFile(long[] part) throws IOException {
        File file = File.createTempFile("part", ".tmp");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (long value : part) {
                pw.println(value);
            }
        }
        return file;
    }

    private void mergeSortedParts(List<File> sortedParts, File sortedFile) throws IOException {
        PriorityQueue<Part> pq = new PriorityQueue<>(sortedParts.size(), Comparator.comparingLong(part -> part.currentValue));
        for (File partFile : sortedParts) {
            Part part = new Part(partFile);
            if (part.hasNext()) {
                part.readNext();
                pq.add(part);
            }
        }

        try (PrintWriter pw = new PrintWriter(sortedFile)) {
            while (!pq.isEmpty()) {
                Part part = pq.poll();
                pw.println(part.currentValue);
                if (part.hasNext()) {
                    part.readNext();
                    pq.add(part);
                }
            }
        }

        for (File partFile : sortedParts) {
            partFile.delete();
        }
    }

    private static class Part {
        Scanner scanner;
        long currentValue;

        Part(File partFile) throws FileNotFoundException {
            scanner = new Scanner(partFile);
        }

        boolean hasNext() {
            return scanner.hasNextLong();
        }

        void readNext() {
            currentValue = scanner.nextLong();
        }

        void close() {
            scanner.close();
        }
    }
}

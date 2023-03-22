package com.company.ThirdLesson.FileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    private static final int DEFAULT_PART_SIZE = 100_000_000;

    public void sortFile(File dataFile, File sortedFile) throws IOException {
        sortFile(dataFile, sortedFile, DEFAULT_PART_SIZE);
    }

    public void sortFile(File dataFile, File sortedFile, int partSize) throws IOException {
        List<long[]> sortedParts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(dataFile))) {
            long[] part = new long[partSize];
            int i = 0;
            while (scanner.hasNextLong()) {
                part[i] = scanner.nextLong();
                i++;
                if (i == partSize) {
                    Arrays.sort(part);
                    sortedParts.add(part);
                    part = new long[partSize];
                    i = 0;
                }
            }
            if (i > 0) {
                Arrays.sort(part, 0, i);
                sortedParts.add(Arrays.copyOf(part, i));
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(sortedParts.size(), new LongArrayComparator());
        pq.addAll(sortedParts);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(sortedFile))) {
            while (!pq.isEmpty()) {
                long[] part = pq.poll();
                for (long value : part) {
                    dos.writeLong(value);
                }
            }
        }
    }

    private static class LongArrayComparator implements Comparator<long[]> {
        @Override
        public int compare(long[] o1, long[] o2) {
            return Long.compare(o1[0], o2[0]);
        }
    }
}
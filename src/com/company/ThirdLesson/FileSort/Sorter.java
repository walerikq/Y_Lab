package com.company.ThirdLesson.FileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    private static final int DEFAULT_PART_SIZE = 100_000_000;

    public File sortFile(File dataFile) throws IOException {
        return sortFile(dataFile, DEFAULT_PART_SIZE);
    }

    public File sortFile(File dataFile, int partSize) throws IOException {
        List<File> sortedParts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(dataFile))) {
            long[] part = new long[partSize];
            int i = 0;
            while (scanner.hasNextLong()) {
                part[i] = scanner.nextLong();
                i++;
                if (i == partSize) {
                    Arrays.sort(part);
                    File partFile = File.createTempFile("part", ".dat");
                    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(partFile))) {
                        for (long value : part) {
                            dos.writeLong(value);
                        }
                    }
                    sortedParts.add(partFile);
                    i = 0;
                }
            }
            if (i > 0) {
                Arrays.sort(part, 0, i);
                File partFile = File.createTempFile("part", ".dat");
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(partFile))) {
                    for (int j = 0; j < i; j++) {
                        dos.writeLong(part[j]);
                    }
                }
                sortedParts.add(partFile);
            }
        }

        File sortedFile = File.createTempFile("sorted", ".dat");
        PriorityQueue<DataInputStream> pq = new PriorityQueue<>(sortedParts.size(), new LongComparator());
        for (File partFile : sortedParts) {
            pq.add(new DataInputStream(new BufferedInputStream(new FileInputStream(partFile))));
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(sortedFile))) {
            while (!pq.isEmpty()) {
                DataInputStream dis = pq.poll();
                long value = dis.readLong();
                dos.writeLong(value);
                if (dis.available() > 0) {
                    pq.add(dis);
                } else {
                    dis.close();
                }
            }
        }

        for (File partFile : sortedParts) {
            partFile.delete();
        }
        return sortedFile;
    }

    private static class LongComparator implements Comparator<DataInputStream> {
        private final IOException e = new IOException();

        @Override
        public int compare(DataInputStream o1, DataInputStream o2) {
            try {
                return Long.compare(o1.readLong(), o2.readLong());
            } catch (IOException e) {
                this.e.initCause(e);
                throw new RuntimeException(this.e);
            }
        }
    }
}

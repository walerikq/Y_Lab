package com.company.SecondLesson.demonstration;

import com.company.SecondLesson.implementation.StatsAccumulatorImpl;

public class StatsAccumulatorTest {
    public static void main(String[] args) {

        StatsAccumulatorImpl statsAccumulator = new StatsAccumulatorImpl();
//        statsAccumulator.add(2);
//        statsAccumulator.add(3);
//        statsAccumulator.add(2);
//        statsAccumulator.add(5);
        System.out.println("max: "+ statsAccumulator.getMax());
        System.out.println("min: "+ statsAccumulator.getMin());
        System.out.println("avg: "+ statsAccumulator.getAvg());
        System.out.println("count: "+ statsAccumulator.getCount());

    }
}

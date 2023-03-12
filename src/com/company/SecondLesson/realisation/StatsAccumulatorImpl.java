package com.company.SecondLesson.realisation;

import com.company.SecondLesson.interfaces.StatsAccumulator;

public class StatsAccumulatorImpl implements StatsAccumulator {

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int count = 0;
    private double sum = 0.0;


    @Override
    public void add(int value) {
        count++;
        if (value < min){
            min = value;
        }
        if(value>max){
            max = value;
        }
        sum +=value;

    }

    @Override
    public int getMin() {
        if (count == 0){
            System.out.println("Не было добавлено ни одного элемента.");
        }

        return min;
    }

    @Override
    public int getMax() {
        if (count == 0){
            System.out.println("Не было добавлено ни одного элемента.");
        }
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        if (count == 0){
            return 0.0;
        }
        return sum/count;
    }
}

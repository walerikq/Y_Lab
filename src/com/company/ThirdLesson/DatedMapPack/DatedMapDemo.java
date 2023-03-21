package com.company.ThirdLesson.DatedMapPack;

public class DatedMapDemo {
    public static void main(String[] args) throws InterruptedException {
        DatedMapImpl datedMap = new DatedMapImpl();
        datedMap.put("First","1111");
        Thread.sleep(10000);
        datedMap.put("Second","2222");
        Thread.sleep(10000);
        datedMap.put("Third","3333");
        Thread.sleep(10000);
        datedMap.put("Forth","4444");
        System.out.println(datedMap.getKeyLastInsertionDate("Forth"));
        System.out.println(datedMap.getKeyLastInsertionDate("For"));
        System.out.println(datedMap.getKeyLastInsertionDate("First"));
        System.out.println(datedMap.keySet());
    }
}

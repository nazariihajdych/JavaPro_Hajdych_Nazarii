package com.hillel.hajdych.homeworks.hw10;

import java.util.Arrays;

public class ValueCalculator {

    private final int arraySize = 1_000_000;
    private final int halfOfArraySize = arraySize/2;
    private double[] numbers = new double[arraySize];
    private double[] numArrayHalfOne = new double[halfOfArraySize];
    private double[] numArrayHalfTwo = new double[halfOfArraySize];

    private long startTime;

    public void arrayDivider(){
        startTime = System.currentTimeMillis();

        Arrays.fill(numbers, 1);
        System.arraycopy(numbers, 0, numArrayHalfOne, 0, halfOfArraySize);
        System.arraycopy(numbers, halfOfArraySize, numArrayHalfTwo,0,halfOfArraySize);


        Runnable run1 = () -> {
            for (int i = 0; i < numArrayHalfOne.length; i++) {
                numArrayHalfOne[i] = (float)(numArrayHalfOne[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                        Math.cos(0.4f + i/2));
            }
        };
        Thread t1 = new Thread(run1);

        Runnable run2 = () -> {
            for (int i = 0; i < numArrayHalfTwo.length; i++) {
                numArrayHalfTwo[i] = (float)(numArrayHalfTwo[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                        Math.cos(0.4f + i/2));
            }
        };
        Thread t2 = new Thread(run2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted!");
        }

        System.arraycopy(numArrayHalfOne, 0, numbers, 0, halfOfArraySize);
        System.arraycopy(numArrayHalfTwo, 0, numbers, halfOfArraySize, halfOfArraySize);

        System.out.println("Час роботи програми: " + (double) (System.currentTimeMillis() - startTime)/1000 + " сек.");
    }

}

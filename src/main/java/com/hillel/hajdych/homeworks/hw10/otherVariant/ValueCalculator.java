package com.hillel.hajdych.homeworks.hw10.otherVariant;

import java.util.Arrays;

public class ValueCalculator {
    public static void main(String[] args) {

        int arraySize = 1_000_000;
        int halfOfArraySize = arraySize/2;
        double[] numbers = new double[arraySize];
        double[] numArrayHalfOne = new double[halfOfArraySize];
        double[] numArrayHalfTwo = new double[halfOfArraySize];
        long time = System.currentTimeMillis();

        Arrays.fill(numbers, 1);
        System.arraycopy(numbers, 0, numArrayHalfOne, 0, halfOfArraySize);
        System.arraycopy(numbers, halfOfArraySize, numArrayHalfTwo,0,halfOfArraySize);

        withoutThreads(numArrayHalfOne, numArrayHalfTwo);

        Arrays.fill(numArrayHalfOne, 1);
        Arrays.fill(numArrayHalfTwo, 1);

        withThreads(numArrayHalfOne, numArrayHalfTwo);

        System.arraycopy(numArrayHalfOne, 0, numbers, 0, halfOfArraySize);
        System.arraycopy(numArrayHalfTwo, 0, numbers, halfOfArraySize, halfOfArraySize);

        System.out.println("Загальний час роботи програми: "
                + (double) (System.currentTimeMillis() - time)/1000 + " сек.");
    }

    public static void withThreads(double[] arrayOne, double[] arrayTwo){
        long timeOne = System.currentTimeMillis();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float)(arrayOne[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                        Math.cos(0.4f + i/2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arrayTwo.length; i++) {
                arrayTwo[i] = (float)(arrayTwo[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                        Math.cos(0.4f + i/2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Час обчислення в двох потоках: "
                + (double) (System.currentTimeMillis() - timeOne)/1000 + " сек.");
    }

    public static void withoutThreads(double[] arrayOne, double[] arrayTwo){
        long timeTwo = System.currentTimeMillis();
        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = (float)(arrayOne[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                    Math.cos(0.4f + i/2));
        }

        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = (float)(arrayTwo[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) *
                    Math.cos(0.4f + i/2));
        }

        System.out.println("Час обчислення в одному потоці: "
                + (double) (System.currentTimeMillis() - timeTwo)/1000 + " сек.");
    }

}

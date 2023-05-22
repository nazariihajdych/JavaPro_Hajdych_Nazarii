package com.hillel.hajdych.homeworks.hw11.PetrolStation;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation {

    private int amount;
    private final ReentrantReadWriteLock lock;
    private final Lock readLock;
    private final Lock writeLock;
    private final ExecutorService executor;
    private final Random random;


    public PetrolStation(int amount) {
        this.amount = amount;
        this.executor = Executors.newFixedThreadPool(3);
        this.lock = new ReentrantReadWriteLock(true);
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
        this.random = new Random();
    }

    public void doRefuel(int howMuchLiters) {
        executor.submit(() -> {
            lock.writeLock();
            try {
                Thread.sleep(random.nextInt(3, 11) * 1000L);
                if (amount == 0) {
                    System.out.println("\nНа заправній станції закінчилося паливо!");
                } else if (howMuchLiters > amount) {
                    System.out.println("\nЗаправляє \"" + Thread.currentThread().getName() +
                                       "\" На заправній станції не вистачає палива.\nАвтомобіль заправлено на: "
                                       + amount + " л.");
                    amount = 0;
                } else {
                    amount -= howMuchLiters;
                    System.out.println("\nЗаправляє \"" + Thread.currentThread().getName() +
                                       "\" Автомобіль заправлено на " + howMuchLiters + " л.");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted " + e.getMessage());
            } finally {
                writeLock.unlock();
            }
        });
    }

    public double getAmount() {
        try {
            readLock.lock();
            return amount;
        } finally {
            readLock.unlock();
        }
    }

    public void closePetrol() {
        executor.shutdown();
    }
}


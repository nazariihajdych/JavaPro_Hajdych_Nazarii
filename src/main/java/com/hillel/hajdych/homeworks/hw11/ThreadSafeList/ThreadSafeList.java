package com.hillel.hajdych.homeworks.hw11.ThreadSafeList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private List<T> list;
    private ReentrantReadWriteLock lock;
    private Lock readLock;
    private Lock writeLock;

    public ThreadSafeList() {
        this.list = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock(true);
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
    }

    public void add(T value){
        writeLock.lock();
        try {
            list.add(value);
        }finally {
            writeLock.unlock();
        }
    }

    public void remove(T value){
        writeLock.lock();
        try {
            list.remove(value);
        }finally {
            writeLock.unlock();
        }
    }

    public T get(int i){
        readLock.lock();
        try {
            return list.get(i);
        }finally {
            readLock.unlock();
        }
    }

}

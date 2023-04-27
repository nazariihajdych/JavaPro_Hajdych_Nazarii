package com.hillel.hajdych.homeworks.hw4;

public class Cat extends Animals {

    private static int catCounter = 0;
    final private int catRunMax = 200;
    private String catName;

    public Cat(String catName) {
        catCounter++;
        this.catName = catName;
    }

    @Override
    public void run(double barrierLength) {
        if(barrierLength <= 0) {
            System.out.println("Неправильне значення довжини перешкоди!");
        }else {
            if (barrierLength <= catRunMax) {
                System.out.println(catName + " пробіг " + barrierLength + " м.");
            } else {
                System.out.println(catName + " не зміг пройти перешкоду, довжина перешкоди в "
                        + barrierLength + " м. занадто велика!");
            }
        }

    }

    @Override
    public void swim(double barrierLength) {
        System.out.println(catName + " не вміє плавати!");
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}

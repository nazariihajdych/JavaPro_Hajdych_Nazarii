package com.hillel.hajdych.homeworks.hw4;

public class Dog extends Animals {

    private static int dogCounter = 0;
    final private int dogRunMax = 500;
    final private int dogSwimMax = 10;

    private String dogName;

    public Dog(String dogName) {
        dogCounter++;
        this.dogName = dogName;
    }

    @Override
    public void run(double barrierLength) {
        if(barrierLength <= 0) {
            System.out.println("Неправильне значення довжини перешкоди!");
        }else {
            if (barrierLength <= dogRunMax) {
                System.out.println(dogName + " пробіг " + barrierLength + " м.");
            } else {
                System.out.println(dogName + " не зміг пройти перешкоду, довжина перешкоди в "
                        + barrierLength + " м. занадто велика!");
            }
        }
    }

    @Override
    public void swim(double barrierLength) {
        if(barrierLength <= 0) {
            System.out.println("Неправильне значення довжини перешкоди!");
        }else {
            if (barrierLength <= dogSwimMax) {
                System.out.println(dogName + " проплив " + barrierLength + "м.");
            } else {
                System.out.println(dogName + " не зміг проплисти перешкоду, довжина перешкоди в "
                        + barrierLength + " м. занадто велика!");
            }
        }
    }

    public static int getDogCounter() {
        return dogCounter;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}

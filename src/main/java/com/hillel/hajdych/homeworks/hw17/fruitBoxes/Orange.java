package com.hillel.hajdych.homeworks.hw17.fruitBoxes;

public class Orange extends Fruit{

    public Orange() {
        weight = 1.5F;
    }

    public Orange(float fruitWeight) {
        weight = fruitWeight;
    }

    @Override
    public String toString() {
        return "Orange {" +
                "weight = " + weight +
                '}';
    }
}

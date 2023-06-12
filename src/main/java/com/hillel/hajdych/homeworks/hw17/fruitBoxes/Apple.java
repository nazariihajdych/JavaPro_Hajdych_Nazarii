package com.hillel.hajdych.homeworks.hw17.fruitBoxes;

public class Apple extends Fruit {

    public Apple() {
        weight = 1.0F;
    }

    public Apple(float fruitWeight) {
        weight = fruitWeight;
    }

    @Override
    public String toString() {
        return "Apple {" +
                "weight = " + weight +
                '}';
    }
}

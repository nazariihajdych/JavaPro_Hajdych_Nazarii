package com.hillel.hajdych.homeworks.hw5.hw_part1;

public class Square implements Shapes{

    private double sideSize;

    public Square(double sideSize) {
        this.sideSize = sideSize;
    }

    @Override
    public double areaOf() {
        return Math.pow(sideSize, 2);
    }

    @Override
    public String toString() {
        return "Square {" +
                "sideSize = " + sideSize +
                '}';
    }
}

package com.hillel.hajdych.homeworks.hw5.hw_part1;

public class Circle implements Shapes{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double areaOf() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius = " + radius +
                '}';
    }
}

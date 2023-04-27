package com.hillel.hajdych.homeworks.hw5.hw_part1;

public class Triangle implements Shapes{

    private double sideOne, sideTwo, sideThree;

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    @Override
    public double areaOf() {
        double halfP = (sideOne + sideTwo + sideThree) / 2;
        double formula = halfP * (halfP - sideOne) * (halfP - sideTwo) * (halfP - sideThree);
        if (formula < 0) {
            System.out.println("Трикутника зі сторонами " + sideOne + ", " + sideTwo + ", " + sideThree + " не існує! " +
                    "Площа  не обрахована!");
            return 0;
        } else {
            return Math.sqrt(formula);
        }
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "sideOne = " + sideOne +
                ", sideTwo = " + sideTwo +
                ", sideThree = " + sideThree +
                '}';
    }
}

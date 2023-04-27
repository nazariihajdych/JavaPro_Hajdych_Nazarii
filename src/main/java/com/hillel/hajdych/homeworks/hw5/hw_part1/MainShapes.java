package com.hillel.hajdych.homeworks.hw5.hw_part1;

public class MainShapes {
    public static void main(String[] args) {

        Shapes[] shapes = {
                new Circle(12),
                new Circle(9),
                new Square(7),
                new Square(5),
                new Triangle(10, 12, 13),
                new Triangle(17, 10, 21)
        };


        for (Shapes shape: shapes) {
            System.out.println("Площа: " + shape.toString() + " = " +  shape.areaOf());
        }



        System.out.println(sumArea(shapes));
    }

    public static double sumArea(Shapes[] shapes){
        double sum = 0;
        for (Shapes shape: shapes) {
            sum += shape.areaOf();
        }
        System.out.print("Сума площ геометричних фігур: ");
        return sum;
    }
}

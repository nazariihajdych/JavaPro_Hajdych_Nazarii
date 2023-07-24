package com.hillel.hajdych.homeworks.hw23;

import com.hillel.hajdych.homeworks.hw23.builder.Car;
import com.hillel.hajdych.homeworks.hw23.factory.Furniture;
import com.hillel.hajdych.homeworks.hw23.factory.FurnitureFactory;
import com.hillel.hajdych.homeworks.hw23.factory.FurnitureType;
import com.hillel.hajdych.homeworks.hw23.strategy.AreaCalculator;
import com.hillel.hajdych.homeworks.hw23.strategy.Rectangle;
import com.hillel.hajdych.homeworks.hw23.strategy.Shape;
import com.hillel.hajdych.homeworks.hw23.strategy.Triangle;

public class Main {
    public static void main(String[] args) {

        System.out.println("Шаблон проектування \"Фабрика\":");
        System.out.println();

        FurnitureFactory furnitureFactory = new FurnitureFactory();

        Furniture table = furnitureFactory.createFurniture(FurnitureType.TABLE);
        Furniture chair = furnitureFactory.createFurniture(FurnitureType.CHAIR);
        Furniture sofa = furnitureFactory.createFurniture(FurnitureType.SOFA);
        table.create();
        chair.create();
        sofa.create();

        System.out.println();
        System.out.println("Шаблон проектування \"Будівельник\":");
        System.out.println();

        Car car = Car.getCarBuilder()
                .setWheelsType("winter type")
                .setEngineType("electric")
                .build();

        System.out.println(car);
        System.out.println();

        System.out.println("Шаблон проектування \"Стратегія\":");

        Shape triangle = new Triangle(6, 9);
        Shape rectangle = new Rectangle(5, 15);

        System.out.println("Площа трикутника: " + AreaCalculator.calculateArea(triangle));
        System.out.println("Площа трикутника: " + AreaCalculator.calculateArea(rectangle));


    }
}

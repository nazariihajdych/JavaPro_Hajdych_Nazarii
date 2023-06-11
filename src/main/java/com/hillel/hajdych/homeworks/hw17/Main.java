package com.hillel.hajdych.homeworks.hw17;

import com.hillel.hajdych.homeworks.hw17.fruitBoxes.Apple;
import com.hillel.hajdych.homeworks.hw17.fruitBoxes.Box;
import com.hillel.hajdych.homeworks.hw17.fruitBoxes.Orange;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();

        Apple[] fewApples = new Apple[]{
                new Apple(),
                new Apple(),
                new Apple()
        };

        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(fewApples);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(List.of(new Orange(), new Orange()));

        System.out.println("Вага ящика яблук = " + appleBox.getWeight() + " кг");
        System.out.println("Вага ящика апельсин = " + orangeBox.getWeight() + " кг");
        System.out.println();

        System.out.println("Чи рівні за вагою ящик апельсин та яблук: " + appleBox.compare(orangeBox));
        System.out.println();

        Box<Apple> otherAppleBox = new Box<>();
        otherAppleBox.merge(appleBox);
        System.out.println("Чи рівні за вагою ящики яблук: " + appleBox.compare(otherAppleBox));

    }
}
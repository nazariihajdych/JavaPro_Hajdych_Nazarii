package com.hillel.hajdych.homeworks.hw4;

public class Animals {

    private static int animalCounter = 0;

    public Animals() {
        animalCounter++;
    }

    public void run(double barrierLength){
        System.out.println("Не визначина тварина для проходження перешкоди!");
    }

    public void swim(double barrierLength){
        System.out.println("Не визначина тварина для проходження перешкоди!");
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }
}

package com.hillel.hajdych.homeworks.hw4;

public class MainObstacles {
    public static void main(String[] args) {

        Animals catSansa = new Cat("Murkit");
        Animals dogBoris = new Dog("Boris");
        Cat catLasun = new Cat("Lasun");
        Dog dogOskar = new Dog("Oskar");

        catSansa.run(123);
        catSansa.swim(12);
        dogBoris.run(1099);
        dogBoris.swim(10);
        catLasun.run(234);
        catLasun.swim(123);
        dogOskar.run(450);
        dogOskar.swim(23);

        System.out.println("Всього створено тварин: " + Animals.getAnimalCounter());
        System.out.println("Створено котів - " + Cat.getCatCounter() + " , собак - " + Dog.getDogCounter());





    }
}

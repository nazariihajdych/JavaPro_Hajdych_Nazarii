package com.hillel.hajdych.homeworks.hw4;

public class MainObstacles {
    public static void main(String[] args) {

        Animals catMurkit = new Cat("Муркіт");
        Animals dogBoris = new Dog("Борис");
        Cat catLasun = new Cat("Ласун");
        Dog dogOskar = new Dog("Оскар");

        catMurkit.run(123);
        catMurkit.swim(12);
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

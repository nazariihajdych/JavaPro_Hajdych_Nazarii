package com.hillel.hajdych.homeworks.hw14.coffee;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();


        coffeeOrderBoard.add("Cappuccino", "Назар");
        coffeeOrderBoard.add("Frappuccino", "Аліна");
        coffeeOrderBoard.add("Espresso", "Віталік");

        coffeeOrderBoard.draw();

        System.out.println(coffeeOrderBoard.deliver());

        coffeeOrderBoard.draw();

        coffeeOrderBoard.add("Ice Latte", "Олег");
        coffeeOrderBoard.add("Americano", "Назар");
        coffeeOrderBoard.add("Espresso", "Орист");
        coffeeOrderBoard.add("Espresso", "Аліна");

        coffeeOrderBoard.draw();

        System.out.println(coffeeOrderBoard.deliver(2));
        System.out.println(coffeeOrderBoard.deliver(5));
        System.out.println(coffeeOrderBoard.deliver(3));
        System.out.println(coffeeOrderBoard.deliver(4));
        System.out.println(coffeeOrderBoard.deliver(6));
        System.out.println(coffeeOrderBoard.deliver(7));

        coffeeOrderBoard.draw();

        coffeeOrderBoard.add("Americano", "Назар");
        coffeeOrderBoard.add("Espresso", "Орист");
        coffeeOrderBoard.add("Frappuccino", "Аліна");
        coffeeOrderBoard.add("Espresso", "Віталік");
        coffeeOrderBoard.add("Cappuccino", "Назар");

        coffeeOrderBoard.draw();

        System.out.println(coffeeOrderBoard.deliver(3));
        System.out.println(coffeeOrderBoard.deliver(5));
        System.out.println(coffeeOrderBoard.deliver());

        coffeeOrderBoard.draw();



    }
}

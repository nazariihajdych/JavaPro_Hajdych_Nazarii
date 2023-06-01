package com.hillel.hajdych.homeworks.hw14.coffee;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();


        coffeeOrderBoard.add("Capuchino", "Nazar");
        coffeeOrderBoard.add("Frapuchino", "Alina");
        coffeeOrderBoard.add("Espresso", "Vitalik");

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();

        coffeeOrderBoard.add("Capuchino", "Nazar");
        coffeeOrderBoard.add("Capuchino", "Nazar");
        coffeeOrderBoard.add("Frapuchino", "Alina");
        coffeeOrderBoard.add("Espresso", "Vitalik");

        coffeeOrderBoard.deliver(2);
        coffeeOrderBoard.deliver(5);

        coffeeOrderBoard.draw();
    }
}

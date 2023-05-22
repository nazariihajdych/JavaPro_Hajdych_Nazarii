package com.hillel.hajdych.homeworks.hw11.PetrolStation;

import java.util.Scanner;

public class MainPetrol {

    public static void main(String[] args) {

        PetrolStation petrolStation = new PetrolStation(1000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть кількість літер заправки: ");
            if (petrolStation.getAmount() == 0) {
                petrolStation.closePetrol();
                break;
            }
            if (scanner.hasNextInt()) {
                petrolStation.doRefuel(scanner.nextInt());
                scanner.nextLine();
            } else {
                System.out.println("Некоректні дані! Спробуйте знову.");
                scanner.nextLine();
            }
        }
    }
}

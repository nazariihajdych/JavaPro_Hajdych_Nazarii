package com.hillel.hajdych.homeworks.hm2;

import com.hillel.hajdych.homeworks.hm2.car.Car;

public class Main {
    public static void main(String[] args) {

        //доступ до полів співробітників через getter & setter
        Employee employee1 = new Employee("Гончарук Петро Дмитрович", "Начальник відділу",
                "honcharuk.petro@gmail.com", "098-343-23-23",  47);
        Employee employee2 = new Employee("Боривець Марина Петрівна", "Секретарка",
                "boryvets.maryna@gmail.com", "098-565-63-24",  32);

        System.out.println(employee1);
        System.out.println(employee2);

        employee1.setPosition("Замісник начальника");

        System.out.println(employee1);
        System.out.println();
        System.out.println();

        //третя частина завдання
        Car car1 = new Car("BMW", "X5");
        Car car2 = new Car("Honda", "CRV");

        car1.start();
        System.out.println();
        car2.start();

    }
}

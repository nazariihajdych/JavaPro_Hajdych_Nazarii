package com.hillel.hajdych.homeworks.hw6;

public class HomeWorkApp {
    public static void main(String[] args) {

        System.out.println("Завдання №2 - вивід рядка в стовпець");
        printThreeWords();
        System.out.println("------------");

        System.out.println("Завдання №3 - чи сума a і b >= 0");
        checkSumSign();
        System.out.println("------------");

        System.out.println("Завдання №4 - кольори");
        printColor();
        System.out.println("------------");

        System.out.println("Завдання №5 - порівняння a і b");
        compareNumbers();
        System.out.println("------------");

        System.out.println("Завдання №6 - чи сума двох чисел в межах від 10 до 20");
        System.out.println(sumCheck(7, 3));
        System.out.println("------------");

        System.out.println("Завдання №7 - додатнє чи відємне число");
        posNegNumber(-3);
        System.out.println("------------");

        System.out.println("Завдання №8 - true - негативне, false - позитивне");
        System.out.println(reversePosNegNumber(34));
        System.out.println("------------");

        System.out.println("Завдання №9 - виведення рядка задану кількість раз");
        printNumbOfTime("Hello world", 5);
        System.out.println("------------");

        System.out.println("Завдання №10 - чи високосний рік");
        System.out.println(leapYear(2016));
        System.out.println("------------");
    }

    static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign(){
        int a = -31, b = 11;
        System.out.println(((a + b) >= 0) ? "Сума позитивна" : "Сума негативна");
    }

    static void printColor(){
        int value = 210;
        if (value <= 0){
            System.out.println("Червоний");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жовтий");
        }else {
            System.out.println("Зелений");
        }
    }

    static void compareNumbers(){
        int a= 12, b = 32;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    static boolean sumCheck(int a, int b){
        return ((a + b) >= 10 && (a +b) <= 20);
    }

    static void posNegNumber(int a) {
        System.out.println(a >= 0 ? "Число додатнє" : "Число відємне");
    }

    static boolean reversePosNegNumber(int a){
        return a < 0;
    }

    static void printNumbOfTime(String str, int times){
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    static boolean leapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}

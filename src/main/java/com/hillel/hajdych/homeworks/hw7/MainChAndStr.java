package com.hillel.hajdych.homeworks.hw7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainChAndStr {
    public static void main(String[] args) {

        System.out.println("Завдання №2");
        System.out.println(findSymbolOccurrence("Назарій", 'р'));
        System.out.println("------------");

        System.out.println("Завдання №3");
        System.out.println(findWordPosition("Назарій", "арій"));
        System.out.println("------------");

        System.out.println("Завдання №4");
        System.out.println(stringReverse("Назарій"));
        System.out.println("------------");

        System.out.println("Завдання №5");
        System.out.println(isPalindrome("Корок"));
        System.out.println("------------");

        System.out.println("Завдання №6");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String category = "Овочі,фрукти";

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String computerChoice = words[random.nextInt(words.length)];

        char[] saveAnswer = new char[15];
        Arrays.fill(saveAnswer, '#');

        System.out.println("Компʼютер загадав слово! Спробуйте відгадати його!");
        System.out.println("Категорія: " + category + " (англійською)");

        System.out.println("Щоб отримати підказку введіть: help \nВийти з гри: exit");
        System.out.println();

        while (true) {
            System.out.print("Введіть ваш здогадку: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equalsIgnoreCase("help")){
                System.out.println();
                System.out.println("---------------------------------------");
                for (int i = 0; i < words.length; i++) {
                    System.out.print(words[i] + " ");
                    if ((i+ 1) % 5 == 0) System.out.println();
                }
                System.out.println("---------------------------------------");
                System.out.println("Компʼютер загадав слово із цього списку)");
                System.out.println("---------------------------------------");
                System.out.println();
            }

            if (userChoice.equals("exit"))break;

            int length = Math.min(computerChoice.length(), userChoice.length());

            for (int i = 0; i < length; i++) {
                if (userChoice.charAt(i) == computerChoice.charAt(i)) {
                    saveAnswer[i] = computerChoice.charAt(i);
                }
            }

            System.out.println(saveAnswer);

            if (computerChoice.equals(userChoice)) {
                System.out.println("Вітаю ви перемогли!!!");
                break;
            }
        }
    }

    static int findSymbolOccurrence(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) counter++;
        }
        return counter;
    }

    static int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target);
        } else {
            return -1;
        }
    }

    static String stringReverse(String str) {
        StringBuilder origin = new StringBuilder(str);
        return String.valueOf(origin.reverse());
    }

    static boolean isPalindrome(String str) {
        return stringReverse(str).equalsIgnoreCase(str);
    }

}

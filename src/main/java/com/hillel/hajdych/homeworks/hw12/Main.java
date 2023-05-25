package com.hillel.hajdych.homeworks.hw12;

import com.hillel.hajdych.homeworks.hw12.phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        String[] sample = new String[]{"nazar", "volodya", "henry", "sansa", "oksana"};
        int howMuchWords = 20;
        List<String> testStrList = new ArrayList<>();

        for (int i = 0; i < howMuchWords; i++) {
            testStrList.add(sample[random.nextInt(0,sample.length)]);
        }

        System.out.println("Тестовий список: " + testStrList);
        System.out.println("Завдання №1 - countOccurrence");
        String word = "nazar";
        System.out.println("Слово \"" + word + "\" в списку " + countOccurrence(testStrList, word) + " екз;");
        System.out.println("-----------------------");


        System.out.println("Завдання №2 - toList");
        Integer[] array = new Integer[12];
        Arrays.fill(array, 27);
        System.out.println("Масив перетворений в список: " + toList(array));
        System.out.println("-----------------------");

        System.out.println("Завдання №3 - findUnique");
        List<Integer> testInt = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testInt.add(random.nextInt(1, 11));
        }
        System.out.println("Оригінальний список: " + testInt);
        System.out.println("Унікальні значення: " + findUnique(testInt));
        System.out.println("-----------------------");

        System.out.println("Завдання №4** - calcOccurrence");
        calcOccurrence(testStrList);
        System.out.println("-----------------------");

        System.out.println("Завдання №4*** - findOccurrence");
        List<Occurrence> newOccurrList = new ArrayList<>(findOccurrence(testStrList));
        for (Occurrence o: newOccurrList) {
            System.out.println(o.toString());
        }
        System.out.println("-----------------------");

        System.out.println("Завдання №5 - PhoneBook");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("nazar", "0680992348");
        phoneBook.add("vasil", "0982343445");
        phoneBook.add("volodymyr", "0963455637");
        phoneBook.add("nastya", "0773456778");
        phoneBook.add("Nazar", "0983456738");
        phoneBook.add("oleksii", "0673457878");
        phoneBook.add("vasil", "0995673467");

        System.out.println(phoneBook.find("nazar"));
        System.out.println(phoneBook.findAll("vasil"));
        System.out.println(phoneBook.findAll("oleksii"));
        System.out.println("-----------------------");
    }

    public static int countOccurrence(List<String> listStr, String str) {
        int counter = 0;
        for (String s : listStr) {
            if (s.equals(str)) counter++;
        }
        return counter;
    }

    //тільки для масивів референсних типів даних
    public static <T> List<T> toList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static List<Integer> findUnique(List<Integer> intList) {
        List<Integer> uniqueNumberList = new ArrayList<>();

        for (Integer i : intList) {
            if (!uniqueNumberList.contains(i)) uniqueNumberList.add(i);
        }

        return uniqueNumberList;
    }

    public static void calcOccurrence(List<String> strList) {
        List<String> uniqueStr = new ArrayList<>();
        int counter = 0;

        for (String str : strList) {
            if (!uniqueStr.contains(str)) uniqueStr.add(str);
        }

        for (String s : uniqueStr) {
            for (String str : strList) {
                if (s.equals(str)) counter++;
            }
            System.out.println(s + " " + counter);
            counter = 0;
        }
    }

    public static List<Occurrence> findOccurrence(List<String> strList) {
        List<String> uniqueStr = new ArrayList<>();
        List<Occurrence> occurrences = new ArrayList<>();
        int counter = 0;

        for (String str : strList) {
            if (!uniqueStr.contains(str)) uniqueStr.add(str);
        }

        for (String s : uniqueStr) {
            for (String str : strList) {
                if (s.equals(str)) counter++;
            }
            occurrences.add(new Occurrence(s, counter));
            counter = 0;
        }
        return occurrences;
    }
}

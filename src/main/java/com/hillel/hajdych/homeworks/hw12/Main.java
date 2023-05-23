package com.hillel.hajdych.homeworks.hw12;

import com.hillel.hajdych.homeworks.hw12.phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        List<String> strList = new ArrayList<>();
        String name = new String("nazar");

        strList.add("nazar");
        strList.add("volodya");
        strList.add("henry");
        strList.add("nazar");
        strList.add("nazar");
        strList.add("Nazar");
        strList.add("volodya");
        strList.add("volodya");
        strList.add("sdfsd");
        strList.add("sdfdsf");


        Double[] array = new Double[12];
        Arrays.fill(array, 12.4);

        List<Double> doubles = new ArrayList<>();

        System.out.println(toList(array));

        System.out.println(strList);

        System.out.println(countOccurrence(strList, name));

        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            test.add(random.nextInt(1, 11));
        }
        System.out.println(test);
        System.out.println(findUnique(test));
        calcOccurrence(strList);
        List<Occurrence> newOcuran = new ArrayList<>(findOccurrence(strList));
        for (Occurrence ocur: newOcuran) {
            System.out.println(ocur.toString());
        }

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("nazar", "1");
        phoneBook.add("vasil", "2");
        phoneBook.add("volodia", "3");
        phoneBook.add("nastya", "4");
        phoneBook.add("nazar", "5");
        phoneBook.add("nazar", "6");
        phoneBook.add("nazar", "7");
        PhoneBook phoneBook2 = new PhoneBook();

        System.out.println(phoneBook.find("vasil"));
        System.out.println(phoneBook.findAll("nazar"));
        System.out.println(phoneBook.findAll("oleksii"));
    }

    public static int countOccurrence(List<String> listStr, String str) {
        int counter = 0;
        for (String s : listStr) {
            if (s.equals(str)) counter++;
        }
        return counter;
    }

    public static <G> List<?> toList(G[] array) {
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

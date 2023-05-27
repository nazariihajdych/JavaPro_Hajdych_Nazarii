package com.hillel.hajdych.homeworks.hw13;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("fileOne.txt");
        fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/fileTwo.txt");
        fileNavigator.add("fileThree.txt");
        fileNavigator.add("fileFour.txt");
        fileNavigator.add("fileFive.txt");
        fileNavigator.add("target");
        fileNavigator.add("fileThr.txt");

        for (String key: fileNavigator.navigator.keySet()) {
            System.out.println(fileNavigator.navigator.get(key));
        }

        System.out.println();
        System.out.println("Finding fileTwo.txt");
        System.out.println(fileNavigator.find("fileTwo.txt"));

        System.out.println();
        int filterBytes = 20;
        System.out.println("Filtering by size: ");
        System.out.println(fileNavigator.filterBySize(filterBytes));

        System.out.println();
        System.out.println("List of files sorted by size: ");
        System.out.println(fileNavigator.sortBySize());

        System.out.println();
        System.out.println("Removing fileOne.txt");
        fileNavigator.remove("fileOne.txt");
        for (String key: fileNavigator.navigator.keySet()) {
            System.out.println(fileNavigator.navigator.get(key));
        }
    }
}

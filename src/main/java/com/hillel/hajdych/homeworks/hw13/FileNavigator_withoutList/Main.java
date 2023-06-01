package com.hillel.hajdych.homeworks.hw13.FileNavigator_withoutList;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("fileOne.txt");
        fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/fileTwo.txt");
        fileNavigator.add("fileThree.txt");
        fileNavigator.add("fileFour.txt");
        fileNavigator.add("fileFive.txt");

        System.out.println("Перевірка на додавання некоректного шляху: ");
        fileNavigator.add("target"); // директорія
        fileNavigator.add("fileThr.txt"); //неіснуючий файл

        System.out.println();
        System.out.println("Список файлів: ");
        for (String key: fileNavigator.navigator.keySet()) {
            System.out.println(fileNavigator.navigator.get(key));
        }

        System.out.println();
        System.out.println("Пошук файла fileTwo.txt");
        System.out.println(fileNavigator.find("fileTwo.txt"));

        System.out.println();
        int filterBytes = 20;
        System.out.println("Фільтрація за розміром файлу <= " + filterBytes + " байтів: ");
        System.out.println(fileNavigator.filterBySize(filterBytes));

        System.out.println();
        System.out.println("Список відсортованих за розміром файлів: ");
        System.out.println(fileNavigator.sortBySize());

        System.out.println();
        System.out.println("Видалення файла fileOne.txt");
        fileNavigator.remove("fileOne.txt");
        for (String key: fileNavigator.navigator.keySet()) {
            System.out.println(fileNavigator.navigator.get(key));
        }
    }
}

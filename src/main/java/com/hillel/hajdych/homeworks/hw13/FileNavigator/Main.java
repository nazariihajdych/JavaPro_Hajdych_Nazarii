package com.hillel.hajdych.homeworks.hw13.FileNavigator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        try {
            fileNavigator.add("fileOne.txt");
            fileNavigator.add("fileTwo.txt");
            fileNavigator.add("fileThree.txt");
            fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw13/testFiles1/fileFour.txt");
            fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw13/testFiles1/fileFive.txt");
            fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw13/testFiles2/fileSix.txt");
            fileNavigator.add("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw13/testFiles2/fileSeven.txt");
            fileNavigator.add("target"); // директорія
            fileNavigator.add("fileThr.txt"); //неіснуючий файл

            System.out.println();
            System.out.println("Список файлів: ");
            printFileNavigator(fileNavigator);

            System.out.println();
            System.out.println("Список файлів повʼязаний із переданим шляхом: ");
            System.out.println(fileNavigator.find("fileOne.txt"));

            System.out.println();
            long filterBytes = 900;
            System.out.println("Список файлів <= " + filterBytes + " байт:");
            System.out.println(fileNavigator.filterBySize(filterBytes));

            System.out.println();
            System.out.println("Список відсортованих за розміром файлів: ");
            System.out.println(fileNavigator.sortBySize());

            System.out.println();
            System.out.println("Видалення шляху і повʼязаних з ним файлів: ");
            fileNavigator.remove("fileOne.txt");
            printFileNavigator(fileNavigator);

        } catch (IOException e) {
            System.out.println("Файлу з імʼям: " + e.getMessage() + " не існує!");
        }
    }

    private static void printFileNavigator(FileNavigator fileNavigator) {
        for (String key : fileNavigator.getNavigator().keySet()) {
            System.out.println("Ключ - " + key + " = [");
            for (FileData file : fileNavigator.getNavigator().get(key)) {
                System.out.println(file);
            }
            System.out.println(" ]");
        }
    }
}

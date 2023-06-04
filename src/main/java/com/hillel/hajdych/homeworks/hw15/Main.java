package com.hillel.hajdych.homeworks.hw15;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array1 = new int[] {67, 32, -1, 32, 9, 2, 9, 3, -21};
        int[] array2 = new int[] {2, 6, 8, -1, 20, 45, 1, -23};

        System.out.println("Вихідний масив #1: " + Arrays.toString(array1));
        SortAlgorithms.quickSort(array1);
        System.out.println("Відсортований масив (алгоритм швидкого сортування): " + Arrays.toString(array1));

        System.out.println();
        System.out.println("Вихідний масив #2: " + Arrays.toString(array2));
        SortAlgorithms.shakeSort(array2);
        System.out.println("Відсортований масив (шейкерний алгоритм): " + Arrays.toString(array2));

    }
}

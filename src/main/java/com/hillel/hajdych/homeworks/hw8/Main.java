package com.hillel.hajdych.homeworks.hw8;

import com.hillel.hajdych.homeworks.hw8.myExceptions.ArrayDataException;
import com.hillel.hajdych.homeworks.hw8.myExceptions.ArraySizeException;


public class Main {

    public static void main(String[] args) {

            ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();

            String[][] str = {
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "w"},
            };
            String[][] str2 = null;
            String[][] str3 = new String[4][4];

            try {
                System.out.println("Сума чисел масиву = " + arrayValueCalculator.doCalc(str));
            } catch (NullPointerException npe) {
                System.err.println("Обʼєкт не проініціалізовано!");
                npe.printStackTrace();
            } catch (ArraySizeException ase) {
                ase.getMessageOfProblem();
                ase.printStackTrace();
            } catch (ArrayDataException ade) {
                System.err.println("Помилка вхідних даних!");
                ade.printStackTrace();
            }

    }
}

package com.hillel.hajdych.homeworks.hw8;

import com.hillel.hajdych.homeworks.hw8.myExceptions.ArrayDataException;
import com.hillel.hajdych.homeworks.hw8.myExceptions.ArraySizeException;

public class ArrayValueCalculator {


    public int doCalc(String[][] s) throws ArrayDataException, ArraySizeException {

        int sum = 0;
        if (s.length == 0 || s[0].length == 0) throw new ArraySizeException();

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {

                if (s.length != 4 || s[i].length != 4){
                    throw new ArraySizeException("Проблема виникла в s[" + i + "][" + j + "]");
                }

                try {
                    sum += Integer.parseInt(s[i][j]);
                }catch (NumberFormatException nfe){
                    if (s[i][j] == null) throw new NullPointerException("Обʼєкти в масиві не проініціалізовані!");
                    throw new ArrayDataException("Неправильний формат рядка в комірці s[" + i + "][" + j + "]" , nfe);
                }
            }
        }
        return sum;
    }
}



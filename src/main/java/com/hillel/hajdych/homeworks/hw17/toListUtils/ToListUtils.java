package com.hillel.hajdych.homeworks.hw17.toListUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToListUtils {

    public static <T> List<T> toList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}

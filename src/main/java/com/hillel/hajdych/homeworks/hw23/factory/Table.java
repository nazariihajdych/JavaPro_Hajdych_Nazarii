package com.hillel.hajdych.homeworks.hw23.factory;

public class Table implements Furniture{
    @Override
    public void create() {
        System.out.println("Виготовлено стіл");
    }
}

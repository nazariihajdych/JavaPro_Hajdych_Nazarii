package com.hillel.hajdych.homeworks.hw12;

public class Occurrence {
    private String name;
    private int occurrence;

    public Occurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "name = \"" + name + '\"' +
                ", occurrence = " + occurrence;
    }
}

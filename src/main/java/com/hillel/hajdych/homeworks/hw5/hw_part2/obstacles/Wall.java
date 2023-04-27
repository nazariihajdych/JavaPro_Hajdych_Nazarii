package com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles;

public class Wall implements Obstacles{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}

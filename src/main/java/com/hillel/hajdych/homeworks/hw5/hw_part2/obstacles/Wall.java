package com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles;

public class Wall implements Obstacles{

    private int height;
    private String nameOfWall;

    public Wall(int height, String nameOfWall) {
        this.height = height;
        this.nameOfWall = nameOfWall;
    }

    public int getHeight() {
        return height;
    }

    public String getNameOfWall() {
        return nameOfWall;
    }
}

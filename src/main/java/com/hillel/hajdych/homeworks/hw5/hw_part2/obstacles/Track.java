package com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles;

public class Track implements Obstacles{

    private int length;
    private String nameOfTrack;

    public Track(int length, String nameOfTrack) {
        this.length = length;
        this.nameOfTrack = nameOfTrack;
    }

    public int getLength() {
        return length;
    }

    public String getNameOfTrack() {
        return nameOfTrack;
    }
}

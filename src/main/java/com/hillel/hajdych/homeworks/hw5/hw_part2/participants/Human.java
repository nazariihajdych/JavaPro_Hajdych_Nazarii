package com.hillel.hajdych.homeworks.hw5.hw_part2.participants;

import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Obstacles;

public class Human extends Participant {

    public Human(String name, int runMax, int jumpMax) {
        super(name, runMax, jumpMax);
    }

    @Override
    public String toString() {
        return "Human";
    }

}

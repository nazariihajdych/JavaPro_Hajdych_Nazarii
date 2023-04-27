package com.hillel.hajdych.homeworks.hw5.hw_part2;

import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Obstacles;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Track;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Wall;
import com.hillel.hajdych.homeworks.hw5.hw_part2.participants.Cat;
import com.hillel.hajdych.homeworks.hw5.hw_part2.participants.Human;
import com.hillel.hajdych.homeworks.hw5.hw_part2.participants.Participant;
import com.hillel.hajdych.homeworks.hw5.hw_part2.participants.Robot;

public class MainCompetition {
    public static void main(String[] args) {

        Obstacles obstacles1 = new Wall(113);
        Obstacles obstacles2 = new Track(1122);
        Participant participant1 = new Human("valera", 123, 11);

        Participant[] allParticipants = {
                new Human("Valera", 123, 11),
                new Cat("Meyou", 123, 123),
                new Robot("Bender", 22,234)
        };

        Obstacles[] allObstacles = {
                new Wall(12),
                new Track(233),
                new Wall(32),
                new Track(123)
        };

        for (int i = 0; i < allParticipants.length; i++) {
            for (int j = 0; j < allObstacles.length; j++) {
                allParticipants[i].overcome(allObstacles[j]);
            }

        }

        System.out.println(allParticipants[0].overcome(allObstacles[0]));
    }
}

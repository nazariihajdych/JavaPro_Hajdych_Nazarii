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


        Participant[] allParticipants = {
                new Human("Валєрій", 100, 3),
                new Cat("Ласун", 125, 15),
                new Robot("Бендер", 502,245)
        };

        Obstacles[] allObstacles = {
                new Wall(4, "Стіна"),
                new Track(220, "Бігова доріжка"),
                new Wall(15, "Паркан"),
                new Track(235, "Стадіон")
        };

        for (int i = 0; i < allParticipants.length; i++) {
            for (int j = 0; j < allObstacles.length; j++) {
                allParticipants[i].overcome(allObstacles[j]);
            }
        }
    }
}

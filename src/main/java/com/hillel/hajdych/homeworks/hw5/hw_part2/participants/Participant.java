package com.hillel.hajdych.homeworks.hw5.hw_part2.participants;

import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Obstacles;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Track;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Wall;

public class Participant {

    private int runMax;
    private int jumpMax;
    private String name;

    private int failureCounter = 0;
    private int numberOfTry = 1;

    public Participant(String name, int runMax, int jumpMax) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }


    public void run() {
        System.out.println(name + " біжить! Команда " + this);
    }

    public void jump() {
        System.out.println(name + " стрибає! Команда " + this);
    }

    public void overcome(Obstacles obstacles) {
        if (obstacles.getClass() == Track.class) {
            if (failureCounter < numberOfTry) {
                run();
                if (((Track) obstacles).getLength() <= runMax) {
                    System.out.println("Учасник " + name + " пройшов перешкоду " + ((Track) obstacles).getNameOfTrack()
                            + " на дистанції " + ((Track) obstacles).getLength() + "м.");
                } else {
                    System.out.println("Учасник " + name + " не пройшов перешкоду " + ((Track) obstacles).getNameOfTrack()
                            + " на дистанції " + ((Track) obstacles).getLength() + "м.");
                    failureCounter++;
                }
            }
        } else if (obstacles.getClass() == Wall.class) {
            if (failureCounter < numberOfTry) {
                jump();
                if (((Wall) obstacles).getHeight() <= jumpMax) {
                    System.out.println("Учасник " + name + " пройшов перешкоду " + ((Wall) obstacles).getNameOfWall()
                            + " висотою " + ((Wall) obstacles).getHeight() + "м.");
                } else {
                    System.out.println("Учасник " + name + " не пройшов перешкоду " + ((Wall) obstacles).getNameOfWall()
                            + " висотою " + ((Wall) obstacles).getHeight() + "м.");
                    failureCounter++;
                }
            }
        }
    }

    public int getFailureCounter() {
        return failureCounter;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public int getRunMax() {
        return runMax;
    }

    public void setRunMax(int runMax) {
        this.runMax = runMax;
    }

    public int getJumpMax() {
        return jumpMax;
    }

    public void setJumpMax(int jumpMax) {
        this.jumpMax = jumpMax;
    }

    @Override
    public String toString() {
        return "Participant {" +
                "name = '" + name + '\'' +
                '}';
    }
}

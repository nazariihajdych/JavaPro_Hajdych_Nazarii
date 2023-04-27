package com.hillel.hajdych.homeworks.hw5.hw_part2.participants;

import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Obstacles;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Track;
import com.hillel.hajdych.homeworks.hw5.hw_part2.obstacles.Wall;

public class Participant {

    public int runMax;
    int jumpMax;

    String name;



    public Participant(String name, int runMax, int jumpMax) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }


    public void run(){
        System.out.println(name + " біжить!");
    }

    public void jump(){
        System.out.println(name + " стрибає!");
    }

    public boolean overcome(Obstacles obstacles){
        if (obstacles.getClass() == null){
            System.out.println("Перешкода не визначена!");
            return false;
        }
        if (obstacles.getClass() == Track.class) {
            run();
            if (((Track) obstacles).getLength() <= runMax) {
                System.out.println(name + " пройшов перешкоду!");
                return true;
            }else {
                System.out.println(name + " не пройшов перешкоду, відстань " + ((Track) obstacles).getLength() + " завелика!");
            return false;
            }
        }else{
            jump();
            if (((Wall) obstacles).getHeight() <= jumpMax) {
                System.out.println(name + " перестрибнув перешкоду!");
                return true;
            }else {
                System.out.println(name + " не перестрибнув перешкоду, висота " + ((Wall) obstacles).getHeight() + " завелика!");
                return false;
            }
        }
    }
}

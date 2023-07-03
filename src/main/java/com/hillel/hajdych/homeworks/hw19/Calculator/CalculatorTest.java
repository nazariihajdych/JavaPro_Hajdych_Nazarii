package com.hillel.hajdych.homeworks.hw19.Calculator;

import com.hillel.hajdych.homeworks.hw19.MyAnnotation.AfterSuite;
import com.hillel.hajdych.homeworks.hw19.MyAnnotation.BeforeSuite;
import com.hillel.hajdych.homeworks.hw19.MyAnnotation.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeSuite
    public void setUp(){
        calculator = new Calculator();
        System.out.println("Початок тестування!");
    }

    @Test(10)
    public void add_test(){
        double a = 10;
        double b = 20;
        double expected = 30;

        double actual = calculator.add(a, b);

        if (actual == expected){
            System.out.println("Тест пройдено!");
        }else {
            System.out.println("Тест не прйдено");
        }
    }

    @Test(2)
    public void subtract_test(){
        double a = 10;
        double b = 20;
        double expected = -10;

        double actual = calculator.subtract(a, b);

        if (actual == expected){
            System.out.println("Тест пройдено!");
        }else {
            System.out.println("Тест не прйдено");
        }

    }

    @AfterSuite
    public void tearDown(){
        System.out.println("Тестування закінчено!");
    }

}

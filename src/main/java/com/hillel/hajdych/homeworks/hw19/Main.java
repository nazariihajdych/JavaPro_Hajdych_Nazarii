package com.hillel.hajdych.homeworks.hw19;

import com.hillel.hajdych.homeworks.hw19.Calculator.CalculatorTest;

public class Main {
    public static void main(String[] args) {
        CalculatorTest calculatorTest = new CalculatorTest();
        TestRunner.start(calculatorTest.getClass());
    }
}

package com.hillel.hajdych.homeworks.hw8.myExceptions;

public class ArraySizeException extends Exception {

    public ArraySizeException() {
    }

    public ArraySizeException(String message) {
        super(message);
    }

    public ArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraySizeException(Throwable cause) {
        super(cause);
    }

    public ArraySizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private final String messageOfProblem = "Некоректна розмірність масиву!";

    public String getMessageOfProblem() {
        System.err.println(messageOfProblem);
        return null;
    }
}

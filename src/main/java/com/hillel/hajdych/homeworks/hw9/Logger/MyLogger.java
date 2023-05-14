package com.hillel.hajdych.homeworks.hw9.Logger;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.LoggerConfiguration;

public abstract class MyLogger {

    protected LoggerConfiguration config;

    public MyLogger(LoggerConfiguration config) {
        this.config = config;
    }

    public abstract void info(String message) throws FileMaxSizeReachedException;
    public abstract void debug(String message) throws FileMaxSizeReachedException;

//    за потреби можна додати методи для інших рівнів логування
}

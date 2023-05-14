package com.hillel.hajdych.homeworks.hw9.Logger;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.LoggerConfiguration;

public class StdoutLogger extends MyLogger{

    public StdoutLogger(LoggerConfiguration config) {
        super(config);
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException {

    }

    @Override
    public void debug(String message) throws FileMaxSizeReachedException {

    }
}

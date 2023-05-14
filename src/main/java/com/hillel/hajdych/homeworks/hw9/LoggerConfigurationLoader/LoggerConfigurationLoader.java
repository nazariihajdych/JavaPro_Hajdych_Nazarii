package com.hillel.hajdych.homeworks.hw9.LoggerConfigurationLoader;

import com.hillel.hajdych.homeworks.hw9.LoggerConfiguration;

import java.io.FileNotFoundException;

public abstract class LoggerConfigurationLoader {
    public abstract LoggerConfiguration load() throws FileNotFoundException;
}

package com.hillel.hajdych.homeworks.hw9;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.Logger.FileLogger;
import com.hillel.hajdych.homeworks.hw9.LoggerConfigurationLoader.FileLoggerConfigurationLoader;

public class LoggerTestMain {
    public static void main(String[] args) {

        String configFilePath = "/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw9/configFile/config.txt";

        FileLoggerConfigurationLoader fileConfLoader = new FileLoggerConfigurationLoader(configFilePath);
        LoggerConfiguration loggerConfiguration = fileConfLoader.load();
        FileLogger fileLogger = new FileLogger(loggerConfiguration, configFilePath);

        try {
            fileLogger.debug("Debug message 1");
            System.out.println("Hello world");
            fileLogger.debug("Debug message 2");
            fileLogger.info("Info message 1");
            fileLogger.debug("Debug message 3");
            fileLogger.info("Info message 2");
            System.out.println("Hello World!");
            fileLogger.info("Info message 3");

        } catch (FileMaxSizeReachedException e) {
            System.out.println("Помилка розміру файла логування" + e.getMessage());
        }





    }
}

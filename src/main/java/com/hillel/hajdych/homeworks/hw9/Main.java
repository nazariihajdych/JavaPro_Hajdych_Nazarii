package com.hillel.hajdych.homeworks.hw9;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.Logger.FileLogger;
import com.hillel.hajdych.homeworks.hw9.LoggerConfigurationLoader.FileLoggerConfigurationLoader;

public class Main {
    public static void main(String[] args) {

        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw9/configFile/config.txt");

        LoggerConfiguration loggerConfiguration = fileLoggerConfigurationLoader.load();

        System.out.println(loggerConfiguration.getFilePath());
        System.out.println(loggerConfiguration.getFormat());
        System.out.println(loggerConfiguration.getLevel());
        System.out.println(loggerConfiguration.getMaxFileSize());

        FileLogger fileLogger = new FileLogger(loggerConfiguration);



        try {
            fileLogger.debug("Debug message");
            fileLogger.debug("fdgdgd");
            fileLogger.info("sdfsdf");
            fileLogger.debug("sdfdsf");
            fileLogger.info("sdfds");
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        }





    }
}

package com.hillel.hajdych.homeworks.hw9.Logger;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.LoggerConfiguration;
import com.hillel.hajdych.homeworks.hw9.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger extends MyLogger{
    public FileLogger(LoggerConfiguration config) {
        super(config);
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException {
        if (config.getLevel().getVal() <= LoggingLevel.INFO.getVal()){
            String logMessage = String.format(config.getFormat(), LocalDateTime.now(), "INFO", message);
            writeToLogFile(logMessage);
        }
    }

    @Override
    public void debug(String message) throws FileMaxSizeReachedException {
        if (config.getLevel().getVal() <= LoggingLevel.DEBUG.getVal()){
            String logMessage = String.format(config.getFormat(), LocalDateTime.now(), "DEBUG", message);
            writeToLogFile(logMessage);
        }

    }

    private void writeToLogFile(String logMessage) throws FileMaxSizeReachedException {
        File loggerFolder = new File("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw9/logFile");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");


        File logFile = new File(config.getFilePath());


        if (logFile.length() + logMessage.length() >= config.getMaxFileSize()) {
            logFile = new File(loggerFolder.getPath() + "/log_" + dateFormat.format(new Date()) + ".txt");
            // logFile.createNewFile();

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/nazar/IdeaProjects/JavaPro_Hajdych/src/main/java/com/hillel/hajdych/homeworks/hw9/configFile/config.txt"))){
                bufferedWriter.write("FILE: " + logFile.getPath());
                bufferedWriter.newLine();
                bufferedWriter.write("LEVEL: " + config.getLevel());
                bufferedWriter.newLine();
                bufferedWriter.write("MAX-SIZE: " + config.getMaxFileSize());
                bufferedWriter.newLine();
                bufferedWriter.write("FORMAT: " + config.getFormat());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//        if (config.getFilePath().length() + logMessage.length() > config.getMaxFileSize()){
//            throw new FileMaxSizeReachedException(config.getMaxFileSize(), (int) logFile.length(), config.getFilePath());
//        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(config.getFilePath(), true))){
            bufferedWriter.write(logMessage);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Помилка запису в файл " + e.getMessage());
        }

    }

    private void createNewLogFile(File logFile){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
        //new File(logFile.getParent() + File.separator + "Log_" + dateFormat.format(new Date()) + ".txt");
        config.setFilePath(logFile.getParent() + File.separator + "Log_" + dateFormat.format(new Date()) + ".txt");
    }
}

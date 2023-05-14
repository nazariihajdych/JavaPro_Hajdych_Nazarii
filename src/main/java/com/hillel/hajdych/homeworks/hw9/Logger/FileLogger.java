package com.hillel.hajdych.homeworks.hw9.Logger;

import com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException.FileMaxSizeReachedException;
import com.hillel.hajdych.homeworks.hw9.LoggerConfiguration;
import com.hillel.hajdych.homeworks.hw9.LoggingLevel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger extends MyLogger{

    private String configPath;
    public FileLogger(LoggerConfiguration config, String configPath) {
        super(config);
        this.configPath = configPath;
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");

        File logFile = new File(config.getFilePath());

        if (logFile.length() + logMessage.length() >= config.getMaxFileSize()) {
            logFile = new File(logFile.getParent() + "/log_" + dateFormat.format(new Date()) + ".txt");

            try (RandomAccessFile randomAccessFile = new RandomAccessFile(configPath, "rw")){
                randomAccessFile.seek(6);
                randomAccessFile.write(logFile.getPath().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (config.getFilePath().length() > config.getMaxFileSize()){
            throw new FileMaxSizeReachedException(config.getMaxFileSize(), (int) logFile.length(), config.getFilePath());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(config.getFilePath(), true))){
            bufferedWriter.write(logMessage);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Помилка запису в файл " + e.getMessage());
        }

    }

}

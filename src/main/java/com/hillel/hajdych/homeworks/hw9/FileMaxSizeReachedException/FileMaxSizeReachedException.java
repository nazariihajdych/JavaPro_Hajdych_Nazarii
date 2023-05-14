package com.hillel.hajdych.homeworks.hw9.FileMaxSizeReachedException;

public class FileMaxSizeReachedException extends Exception{
    public FileMaxSizeReachedException(int maxSize, int currentSize, String filePath) {
        super(String.format("Досягнуто максимального значення розміру файлу %d. Поточний розмір %d, файл %s",
                maxSize, currentSize, filePath));
    }
}

package com.hillel.hajdych.homeworks.hw13.FileNavigator;


import java.util.Objects;

public class FileData implements Comparable<FileData>{

    private final String name;
    private final long size;
    private final String filePath;

    public FileData(String name, long size, String filePath) {
        this.name = name;
        this.size = size;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "[" +
                "name = '" + name + '\'' +
                ", size = " + size +
                ", path = '" + filePath + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return size == fileData.size && Objects.equals(name, fileData.name) && Objects.equals(filePath, fileData.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, filePath);
    }

    @Override
    public int compareTo(FileData o) {
        return (int) (size - o.size);
    }
}

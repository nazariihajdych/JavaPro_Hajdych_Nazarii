package com.hillel.hajdych.homeworks.hw13;

import java.util.Comparator;

public class FileData implements Comparable<FileData>{

    private String name;
    private long size;
    private String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "[" +
                "name = '" + name + '\'' +
                ", size = " + size +
                ", path = '" + path + '\'' +
                ']';
    }


    @Override
    public int compareTo(FileData o) {
        return (int) (size - o.size);
    }
}

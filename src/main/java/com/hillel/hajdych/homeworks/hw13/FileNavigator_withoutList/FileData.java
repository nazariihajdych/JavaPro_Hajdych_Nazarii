package com.hillel.hajdych.homeworks.hw13.FileNavigator_withoutList;


import java.util.Objects;

public class FileData implements Comparable<FileData>{

    private final String name;
    private final long size;
    private final String path;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return size == fileData.size && Objects.equals(name, fileData.name) && Objects.equals(path, fileData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, path);
    }

    @Override
    public int compareTo(FileData o) {
        return (int) (size - o.size);
    }
}

package com.hillel.hajdych.homeworks.hw13.FileNavigator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> navigator = new HashMap<>();

    public void add(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        if (verifyFile(path)) {
            String key = path.toRealPath().getParent().toString();
            List<FileData> newListOfFiles = new ArrayList<>();
            FileData newFile = new FileData(path.getFileName().toString(), Files.size(path), path.toRealPath().toString());
            newListOfFiles.add(newFile);

            if (navigator.containsKey(key)) {
                if (navigator.get(key).contains(newFile)) {
                    return;
                }
                navigator.get(key).add(newFile);
            } else {
                navigator.put(key, newListOfFiles);
            }
        }
    }

    private boolean verifyFile(Path path) {
        if (Files.exists(path)) {
            if (!Files.isDirectory(path)) {
                return true;
            } else {
                System.out.println("Передано шлях до директорії. Файл не додано! - " + path);
                return false;
            }
        } else {
            System.out.println("Файл за даним шляхом не існує. Файл не додано! - " + path);
            return false;
        }
    }

    public List<FileData> find(String filePath) throws IOException {
        return navigator.get(Paths.get(filePath).toRealPath().getParent().toString());
    }

    public List<FileData> filterBySize(long size) {
        List<FileData> fileDataList = new ArrayList<>();
        for (String keyPath : navigator.keySet()) {
            for (FileData file : navigator.get(keyPath)) {
                if (file.getSize() <= size) fileDataList.add(file);
            }
        }

        return fileDataList;
    }

    //видаляє конкретний файл відповідно до переданого шляху
//    public void remove(String filePath) throws IOException {
//    Path path = Paths.get(filePath);
//        navigator.get(path.toRealPath().getParent().toString())
//                .removeIf(file -> file.getFilePath().equals(path.toAbsolutePath().toString()));
//    }

    //видалення усіх файлів повʼязаних з ключем за шляхом
    public void remove(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (verifyFile(path)) {
            navigator.remove(path.toRealPath().getParent().toString());
        }
    }


    public List<FileData> sortBySize() {
        List<FileData> fileDataList = new ArrayList<>();
        for (String key : navigator.keySet()) {
            fileDataList.addAll(navigator.get(key));
        }
        Collections.sort(fileDataList);

        return fileDataList;
    }

    public Map<String, List<FileData>> getNavigator() {
        return navigator;
    }
}


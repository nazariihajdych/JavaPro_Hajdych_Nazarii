package com.hillel.hajdych.homeworks.hw13.FileNavigator_withoutList;

import java.io.File;
import java.util.*;

public class FileNavigator {

    public Map<String, FileData> navigator = new HashMap<>();

    public void add(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()) {
                //перевірка на існування та чи є файл диреторією, а також переіедення в апсолютний шлях гарантує консистентність даних
                navigator.put(file.getAbsolutePath(), new FileData(file.getName(), file.length(), file.getAbsolutePath()));
            } else {
                System.out.println("Передано шлях до директорії. Файл не додано! - " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Файл за даним шляхом не існує. Файл не додано! - " + file.getAbsolutePath());
        }
    }

    public List<FileData> find(String path) {
        File file = new File(path);
        path = file.getAbsolutePath();
        List<FileData> fileDataList = new ArrayList<>();
        for (String keyPath : navigator.keySet()) {
            if (path.equals(keyPath)) fileDataList.add(navigator.get(path));
        }
        return fileDataList;
    }

    public List<FileData> filterBySize(long size) {
        List<FileData> fileDataList = new ArrayList<>();
        for (String keyPath : navigator.keySet()) {
            if (navigator.get(keyPath).getSize() <= size) fileDataList.add(navigator.get(keyPath));
        }

        return fileDataList;
    }

    public void remove(String path) {
        navigator.remove(new File(path).getAbsolutePath());
    }

    public List<FileData> sortBySize() {
        List<FileData> fileDataList = new ArrayList<>(navigator.values());
        Collections.sort(fileDataList);

        return fileDataList;
    }
}

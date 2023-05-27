package com.hillel.hajdych.homeworks.hw13;

import java.io.File;
import java.util.*;

public class FileNavigator {

    public Map<String, FileData> navigator = new HashMap<>();

    public void add(String path){
        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()) {
                path = file.getAbsolutePath();
//                if (!path.equals(navigator.get(path).getPath())) {
//                    System.out.println("Файл не може бути доданим. Ключ і поле path не збігаються");
//                }
                    navigator.put(path, new FileData(file.getName(), file.length(), file.getAbsolutePath()));

            }else {
                System.out.println("Передано шлях до директорії. Файл не додано!");
            }
        }else {
            System.out.println("Неправильний шлях. Файл не додано!");
        }
    }

    public List<FileData> find(String path){
        File file = new File(path);
        path = file.getAbsolutePath();
        List<FileData> fileDataList = new ArrayList<>();
        for (String key: navigator.keySet()) {
            if (path.equals(key)) fileDataList.add(navigator.get(path));
        }
        return fileDataList;
    }

    public List<FileData> filterBySize(long size){
        List<FileData> fileDataList = new ArrayList<>();
        for (String path: navigator.keySet()) {
            if (navigator.get(path).getSize() <= size) fileDataList.add(navigator.get(path));
        }

        return fileDataList;
    }

    public void remove(String path){
        File file = new File(path);
        path = file.getAbsolutePath();

        navigator.remove(path);
    }

    public List<FileData> sortBySize(){
        List<FileData> fileDataList = new ArrayList<>(navigator.values());
        Collections.sort(fileDataList);

        return fileDataList;
    }





}

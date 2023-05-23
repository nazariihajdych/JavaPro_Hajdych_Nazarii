package com.hillel.hajdych.homeworks.hw12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Record> phoneBookList = new ArrayList<>();

    public void add(String name, String phone){
        phoneBookList.add(new Record(name, phone));
    }

    public Record find(String name){
        for (Record rec: phoneBookList) {
            if (rec.getName().equals(name)) return rec;
        }
        return null;
    }

    public List<Record> findAll(String name){
        List<Record> recordsSameName = new ArrayList<>();
        if (!phoneBookList.isEmpty()) {
            for (Record rec : phoneBookList) {
                if (rec.getName().equals(name)) recordsSameName.add(rec);
            }
            if (recordsSameName.isEmpty()){
                return null;
            }else {
                return recordsSameName;
            }
        }else {
            return null;
        }
    }
}

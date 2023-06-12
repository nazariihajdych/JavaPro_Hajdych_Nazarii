package com.hillel.hajdych.homeworks.hw17.fruitBoxes;

import com.hillel.hajdych.homeworks.hw17.toListUtils.ToListUtils;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruitsBox = new ArrayList<>();

    public void add(T fruit) {
        fruitsBox.add(fruit);
    }

    public void add(List<T> fruit) {
        fruitsBox.addAll(fruit);
    }

    public void add(T[] fruit) {
        fruitsBox.addAll(ToListUtils.toList(fruit));
    }

    public float getWeight() {
        float boxWeight = 0;

        for (Fruit fruit : fruitsBox) {
            boxWeight += fruit.weight;
        }
        return boxWeight;
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void merge(Box<T> box) {
        fruitsBox.addAll(box.fruitsBox);
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitsBox=" + fruitsBox +
                '}';
    }
}

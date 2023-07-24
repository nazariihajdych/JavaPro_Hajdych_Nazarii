package com.hillel.hajdych.homeworks.hw23.factory;

public class FurnitureFactory {

    public Furniture createFurniture(FurnitureType type){
        switch (type){
            case TABLE:
                return new Table();
            case SOFA:
                return new Sofa();
            case CHAIR:
                return new Chair();
            default:
                throw new IllegalArgumentException("Невідомий тип - " + type);
        }
    }

}

package com.hillel.hajdych.homeworks.hm2.car;

public class Car {

    private String carName;
    private String carModel;

    public Car(String carName, String carModel) {
        this.carName = carName;
        this.carModel = carModel;
    }

    public void start(){
        System.out.println("Автомобіль " + carName + " " + carModel + " заводиться!");
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity(){
        System.out.println("Запалювання! - " + carName + " " + carModel);
    }

    private void startCommand(){
        System.out.println("Головний компʼютер! - " + carName + " " + carModel);
    }

    private void startFuelSystem(){
        System.out.println("Паливна система! - " + carName + " " + carModel);
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}

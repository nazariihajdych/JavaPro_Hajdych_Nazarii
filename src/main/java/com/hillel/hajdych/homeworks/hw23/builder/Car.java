package com.hillel.hajdych.homeworks.hw23.builder;

public class Car {
    private String wheelsType = "summer type";
    private String engineType = "petrol";
    private String carBodyType = "sedan";

    private Car() {
    }

    public static CarBuilder getCarBuilder(){
        return new CarBuilder();
    }

    public static class CarBuilder {

        private Car newCar;

        public CarBuilder() {
            this.newCar = new Car();
        }

        public CarBuilder setWheelsType(String wheelsType) {
            this.newCar.wheelsType = wheelsType;

            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            this.newCar.engineType = engineType;

            return this;
        }

        public CarBuilder setCarBodyType(String carBodyType) {
            this.newCar.carBodyType = carBodyType;

            return this;
        }

        public Car build(){
            return newCar;
        }
    }

    @Override
    public String toString() {
        return "Car {" +
                "wheelsType = '" + wheelsType + '\'' +
                ", engineType = '" + engineType + '\'' +
                ", carBodyType = '" + carBodyType + '\'' +
                '}';
    }
}

package com.hillel.hajdych.homeworks.hw18;

public class Product {

    private int identifierNumber;
    private String type;
    private float price;
    private boolean discountability;
    private String createDate;

    public Product(int identifierNumber, String type, float price, boolean discountability, String createDate) {
        this.identifierNumber = identifierNumber;
        this.type = type;
        this.price = price;
        this.discountability = discountability;
        this.createDate = createDate;
    }
}

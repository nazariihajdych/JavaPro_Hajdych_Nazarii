package com.hillel.hajdych.homeworks.hw18;

import java.time.LocalDateTime;

public class Product {

    private static int nextIdNum = 1;
    private int identifierNumber;
    private String type;
    private float price;
    private boolean discountability;
    private LocalDateTime createDate;

    public Product(String type, float price) {
        this.identifierNumber = nextIdNum;
        this.type = type;
        this.price = price;
        this.createDate = LocalDateTime.now();
        nextIdNum++;
    }

    public Product(String type, float price, boolean discountability) {
        this.identifierNumber = nextIdNum;
        this.type = type;
        this.price = price;
        this.discountability = discountability;
        this.createDate = LocalDateTime.now();
        nextIdNum++;
    }

    public Product(int identifierNumber, String type, float price, boolean discountability) {
        this.identifierNumber = identifierNumber;
        this.type = type;
        this.price = price;
        this.discountability = discountability;
        this.createDate = LocalDateTime.now();
    }

    public int getIdentifierNumber() {
        return identifierNumber;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isDiscountability() {
        return discountability;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Product { " +
                "identifierNumber = " + identifierNumber +
                ", type = '" + type + '\'' +
                ", price = " + price +
                ", discountability = " + discountability +
                ", createDate = " + createDate +
                '}';
    }
}

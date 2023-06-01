package com.hillel.hajdych.homeworks.hw14.coffee.order;

public class Order {

    private int numberOfOrder;
    private String orderLabel;
    private String costumerName;

    public Order(int numberOfOrder, String orderLabel, String costumerName) {
        this.numberOfOrder = numberOfOrder;
        this.orderLabel = orderLabel;
        this.costumerName = costumerName;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public String getOrderLabel() {
        return orderLabel;
    }

    public String getCostumerName() {
        return costumerName;
    }

    @Override
    public String toString() {
        return "Order { " +
                "numberOfOrder = " + numberOfOrder +
                ", orderLabel = '" + orderLabel + '\'' +
                ", costumerName = '" + costumerName + '\'' +
                '}';
    }
}

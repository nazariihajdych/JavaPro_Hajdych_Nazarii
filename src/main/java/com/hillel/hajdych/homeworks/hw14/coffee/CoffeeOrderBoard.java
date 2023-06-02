package com.hillel.hajdych.homeworks.hw14.coffee;

import com.hillel.hajdych.homeworks.hw14.coffee.order.Order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {

    private Queue<Order> orderQueue = new LinkedList<>();
    private int orderCounter = 1;
    public void add(String orderLabel, String costumerName){
        Order order = new Order(orderCounter, orderLabel, costumerName);
        orderQueue.add(order);
        orderCounter++;
    }

    public Order deliver(){
        return orderQueue.poll();
    }

    public Order deliver(int readyOrder){
        for (Order order: orderQueue) {
            if (order.getNumberOfOrder() == readyOrder) {
                orderQueue.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw(){
        System.out.println("========================");
        for (Order order : orderQueue) {
            System.out.println(order.getNumberOfOrder() + " | " + order.getOrderLabel() + " | " + order.getCostumerName());
        }
    }



}

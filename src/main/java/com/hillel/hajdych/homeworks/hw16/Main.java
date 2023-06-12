package com.hillel.hajdych.homeworks.hw16;

import com.hillel.hajdych.homeworks.hw16.bynaryTree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryThree = new BinaryTree();

        binaryThree.insert(12);
        binaryThree.insert(11);
        binaryThree.insert(1);
        binaryThree.insert(5);
        binaryThree.insert(4);
        binaryThree.insert(7);
        binaryThree.insert(8);

        for (Integer i : binaryThree) {
            System.out.print(" " + i);
        }
    }
}

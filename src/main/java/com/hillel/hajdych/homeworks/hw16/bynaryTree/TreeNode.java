package com.hillel.hajdych.homeworks.hw16.bynaryTree;

public class TreeNode {
    private final int value;
    private TreeNode right;
    private TreeNode left;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }
}

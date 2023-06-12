package com.hillel.hajdych.homeworks.hw16;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {
    private TreeNode root;

    public void insert(int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value){
        if (root == null){
            return new TreeNode(value);
        }

        if (value < root.getValue()){
            root.setLeft(insert(root.getLeft(), value));
        }else {
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }


    @Override
    public Iterator iterator() {
        return new DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<Integer> {
        private Stack<TreeNode> stack = new Stack<>();

        public DepthFirstIterator() {
            this.stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            TreeNode top = stack.pop();

            if (top.getRight() != null){
                stack.push(top.getRight());
            }

            if (top.getLeft() != null){
                stack.push(top.getLeft());
            }

            return top.getValue();
        }
    }
}

package com.basic.framework.dynamic.programming.structures;

public class OptimalBST {

    private double[][] state;
    private int[][] root;

    public int[][] getRoot() {
        return root;
    }

    public void setRoot(int[][] root) {
        this.root = root;
    }

    public double[][] getState() {
        return state;
    }

    public void setState(double[][] state) {
        this.state = state;
    }

    public String printTree(int start, int end, int[][] array) {
        if (start == end)
            return "k" + start;

        int root = array[start][end];

        if (root <= 1) {
            return printTree(start, 1, array) + "<- k" + root + "->" + printTree(root + 1, end, array);
        } else if (root == end) {
            return printTree(start, root - 1, array) + "<- k" + root + "->" + printTree(end, end, array);
        } else {
            return printTree(start, root - 1, array) + "<- k" + root + "->" + printTree(root + 1, end, array);
        }
    }
}

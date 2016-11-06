package com.basic.framework.dynamic.programming;

import com.basic.framework.dynamic.programming.structures.OptimalBST;

class OptimalBinarySearchTree {

    double optimalBinaryTreeCost(final double[][] array, final int start, final int end) {

        if (start - 1 == end) {
            return array[1][start - 1];
        }

        double minimum = Integer.MAX_VALUE;
        double sum = sumAllKeyProbability(array, start, end);

        for (int r = start; r <= end; r++) {
            double result = optimalBinaryTreeCost(array, start, r - 1) + optimalBinaryTreeCost(array, r + 1, end) + sum;

            if (result < minimum) {
                minimum = result;
            }
        }

        return minimum;
    }

    OptimalBST optimalBinaryTreeCostD(final double[][] array) {

        double[][] state = new double[array[0].length + 1][array[0].length];
        double[][] probability = new double[array[0].length + 1][array[0].length];
        int[][] root = new int[array[0].length][array[0].length];

        final OptimalBST optimalBST = new OptimalBST();

        for (int i = 1; i <= array[0].length; i++) {
            state[i][i - 1] = array[1][i - 1];
            probability[i][i - 1] = array[1][i - 1];
        }

        for (int i = 1; i < array[0].length; i++) {
            root[i][i] = i;
        }

        for (int j = 1; j <= array[0].length - 1; j++) {
            for (int i = j; i >= 1; i--) {
                double minimum = Integer.MAX_VALUE;
                probability[i][j] = probability[i][j - 1] + array[0][j] + array[1][j];
                for (int r = i; r <= j; r++) {
                    double result = state[i][r - 1] + state[r + 1][j] + probability[i][j];
                    if (result < minimum) {
                        root[i][j] = r;
                        minimum = result;
                    }
                }
                state[i][j] = minimum;
            }
        }

        optimalBST.setRoot(root);
        optimalBST.setState(state);

        return optimalBST;
    }

    private double sumAllKeyProbability(final double[][] array, int start, int end) {
        double sum = 0;

        for (int i = start; i <= end; i++) {
            sum += array[0][i];
            sum += array[1][i];
        }

        sum += array[1][start - 1];

        return sum;
    }

}

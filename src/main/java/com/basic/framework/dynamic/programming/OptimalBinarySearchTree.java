package com.basic.framework.dynamic.programming;

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

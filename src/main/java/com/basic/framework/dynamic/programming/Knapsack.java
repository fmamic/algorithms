package com.basic.framework.dynamic.programming;

/**
 * Knapsack 01 - Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In
 * other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also
 * given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is
 * smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
class Knapsack {

    int calculateNaive(int[] value, int[] weight, int limit, int n) {

        if (n == 0 || limit == 0) {
            return 0;
        }

        if (weight[n - 1] > limit) {
            return calculateNaive(value, weight, limit, n - 1);
        }
        else {
            return Math.max(value[n - 1] + calculateNaive(value, weight, limit - weight[n - 1], n - 1), calculateNaive(value, weight, limit, n - 1));
        }
    }

    int calculateDP(int[] value, int[] weight, int limit, int n) {

        final int[][] result = new int[n + 1][limit + 1];

        for (int i = 0; i <= limit; i++) {
            result[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            result[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= limit; k++) {
                if (weight[i - 1] <= k) {
                    result[i][k] = Math.max(value[i - 1] + result[i - 1][k - weight[i - 1]], result[i - 1][k]);
                }
                else {
                    result[i][k] = result[i - 1][k];
                }
            }
        }

        return result[n][limit];
    }

}

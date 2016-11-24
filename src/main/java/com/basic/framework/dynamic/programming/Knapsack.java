package com.basic.framework.dynamic.programming;

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
                } else {
                    result[i][k] = result[i-1][k];
                }
            }
        }

        return result[n][limit];
    }

}

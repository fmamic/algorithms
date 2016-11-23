package com.basic.framework.dynamic.programming;

class Knapsack {

    int calculateNaive(int[] value, int[] weight, int limit, int n) {

        if (n == 0 || limit == 0) {
            return value[n];
        }

        if (weight[n] > limit) {
            return calculateNaive(value, weight, limit, n - 1);
        } else {
            return Math.max(value[n] + calculateNaive(value, weight, limit - weight[n], n - 1),
                    calculateNaive(value, weight, limit, n - 1));
        }
    }

}

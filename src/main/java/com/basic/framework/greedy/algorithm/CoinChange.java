package com.basic.framework.greedy.algorithm;

/**
 * Consider the problem of making change for n cents using the fewest number of coins. Assume that each coin’s value is an integer
 */
class CoinChange {

    int calculateNaive(final int[] array, final int sum, final int number) {

        if (number < 0) {
            return 0;
        }

        return Math.min(calculateNaive(array, sum, number - 1), calculateNaive(array, sum - array[number - 1], number - 1) + 1);
    }

}
package com.basic.framework.greedy.algorithm;

/**
 * You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 */
class ActivitySelection {

    int calculateRecursive(final int[][] array, int start, int end) {

        if (array.length == 0) {
            return 0;
        }

        if (start + 1 == end) {
            if (array[end][0] > array[start][1]) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int maximum = 0;

        for (int k = start + 1; k < end; k++) {

            int result;
            if (array[start][1] < array[k][0] && array[end][0] > array[k][1]) {
                result = calculateRecursive(array, start, k) + 1 + calculateRecursive(array, k, end);
            }
            else {
                result = Math.max(calculateRecursive(array, start, k), calculateRecursive(array, k, end));
            }

            if (result > maximum) {
                maximum = result;
            }
        }

        return maximum;
    }

    int calculateDP(final int[][] array) {

        final int[][] result = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            result[i][i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && j == i - 1; j++) {
                if (array[i][0] > array[j][1]) {
                    result[i][j] = 2;
                }
                else {
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                int maximum = 0;
                for (int k = j + 1; k < i; k++) {
                    int temp;
                    if (array[i][0] > array[k][1] && array[j][1] < array[k][0]) {
                        temp = Math.max(result[i][k], result[k][j]) + 1;
                    }
                    else {
                        temp = Math.max(result[i][k], result[k][j]);
                    }

                    if (temp > maximum) {
                        maximum = temp;
                    }
                }
                result[i][j] = maximum;
            }
        }

        return result[array.length - 1][0];
    }

    int calculateGreedy(int[][] array, int position, int total) {
        int next = position + 1;

        while (next <= total && array[position][1] > array[next][0]) {
            next++;
        }

        if (next <= total) {
            return 1 + calculateGreedy(array, next, total);
        }
        else {
            return 1;
        }
    }

    int calculateGreedyIter(int[][] array) {

        int total = 1;
        int lastFinish = array[0][1];

        for (int i = 1; i < array.length; i++) {
            if (lastFinish < array[i][0]) {
                lastFinish = array[i][1];
                total++;
            }
        }

        return total;
    }

}

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

    int calculateGreedy() {

        return 0;
    }

}

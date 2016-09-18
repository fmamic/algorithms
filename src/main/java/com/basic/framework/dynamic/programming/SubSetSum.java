package com.basic.framework.dynamic.programming;

class SubSetSum {

    boolean findSubSetSum(int[] array, int sum) {
        return exploreSubSetSum(array, 0, 0, sum);
    }

    private boolean exploreSubSetSum(int[] array, int index, int currentSum, int sum) {

        if (currentSum == sum) {
            return true;
        }

        // backtracking
        if (currentSum > sum) {
            return false;
        }

        if (array.length == index) {
            return false;
        }

        currentSum += array[index];

        if (exploreSubSetSum(array, index + 1, currentSum, sum)) return true;

        currentSum -= array[index];

        return exploreSubSetSum(array, index + 1, currentSum, sum);

    }

    boolean findSubSetSumD(int array[], int sum) {
        final boolean[][] state = new boolean[array.length + 1][sum + 1];

        for (int i = 0; i < array.length + 1; i++) {
            state[i][0] = true;
        }

        for (int j = 1; j < sum + 1; j++) {
            state[0][j] = false;
        }

        for (int i = 1; i < array.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                state[i][j] = state[i - 1][j];

                if (!state[i][j] && j >= array[i - 1]) {
                    state[i][j] = state[i][j] || state[i - 1][j - array[i - 1]];
                }
            }
        }

        return state[array.length][sum];
    }
}

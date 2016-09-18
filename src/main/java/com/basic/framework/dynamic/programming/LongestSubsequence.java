package com.basic.framework.dynamic.programming;

class LongestSubsequence {

    int longestIncreasingSubsequence(final int[] sequence) {

        final int[] state = new int[sequence.length];
        int maxNumber = Integer.MIN_VALUE;

        state[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            state[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] <= sequence[i] && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                }
            }

            if (state[i] > maxNumber) {
                maxNumber = state[i];
            }
        }

        return maxNumber;
    }


    public int longestZigZag(final int[] sequence) {
        final int[] state = new int[sequence.length + 1];
        final boolean[] zigzag = new boolean[sequence.length + 1];

        int maxNumber = 1;
        state[0] = 1;

        if (sequence.length == 1)
            return 1;

        for (int i = 1; i < sequence.length; i++) {
            state[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] - sequence[j] < 0 && (j == 0 || zigzag[j]) && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                    zigzag[i] = false;
                } else if (sequence[i] - sequence[j] > 0 && (j == 0 || !zigzag[j]) && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                    zigzag[i] = true;
                }
            }
            if (state[i] > maxNumber) {
                maxNumber = state[i];
            }
        }

        return maxNumber;
    }

}

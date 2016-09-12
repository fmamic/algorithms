package com.basic.framework.dynamic.programming;

class LongestIncreasingSubsequence {

    int longestIncreasingSubsequence(final int[] sequence) {

        final int[] state = new int[sequence.length];
        int maxNumber = Integer.MIN_VALUE;

        state[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            state[i] = 1;
            for (int j = 0; j < i; j++) {
                if(sequence[j] <= sequence[i] && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                }
            }

            if(state[i] > maxNumber) {
                maxNumber = state[i];
            }
        }

        return maxNumber;
    }

}

package com.basic.framework.dynamic.programming.structures;

public class MinumumJumps {

    public int minJumpsNaive(final int[] array, final int start, final int end) {

        if (start == end) {
            return 0;
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i <= array[start] && i <= end - start; i++) {
            int result = 1 + minJumpsNaive(array, start + i, end);
            if (result < minimum) {
                minimum = result;
            }
        }

        return minimum;
    }

    public int minJumpsMemoInvoke(final int[] array, final int start, final int end) {
        int[] memo = new int[array.length];

        // memoization
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Integer.MIN_VALUE;
        }

        return minJumpsMemo(array, memo, start, end);
    }

    private int minJumpsMemo(final int[] array, final int[] memo, final int start, final int end) {

        if (start == end) {
            return 0;
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i <= array[start] && i <= end - start; i++) {
            int result;

            if (memo[start + i] != Integer.MIN_VALUE) {
                result = memo[start + i];
            } else {
                result = 1 + minJumpsMemo(array, memo, start + i, end);
                memo[start + i] = result;
            }

            if (result < minimum) {
                minimum = result;
            }
        }

        return minimum;
    }

    public int minJumpsDP(final int[] array) {
        int[] state = new int[array.length];

        for (int i = 1; i < array.length; i++) {
            state[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < state.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int distance = i - j;
                if (distance <= array[j] && state[j] + 1 <= state[i]) {
                    state[i] = state[j] + 1;
                }
            }
        }

        return state[array.length - 1];
    }

    public int minJumpsLinear(final int[] array) {
        final int[] result = new int[array.length];

        result[0] = 0;
        int step = array[0];
        int inc = 0;

        for (int i = 1; i < array.length; i++) {
            inc++;
            if (step - inc < array[i]) {
                step = array[i];
                result[i] += result[i - inc] + 1;
                inc = 0;
            }

            if (step + i >= array.length) {
                return result[i];
            }
        }

        return result[array.length - 1];
    }

}

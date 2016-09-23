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

    public int minJumpsDP(final int[] array, final int end) {


        return 0;
    }
}

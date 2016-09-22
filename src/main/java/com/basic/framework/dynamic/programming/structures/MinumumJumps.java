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


    public int minJumpsDP(final int[] array, final int end) {

        return 0;
    }
}

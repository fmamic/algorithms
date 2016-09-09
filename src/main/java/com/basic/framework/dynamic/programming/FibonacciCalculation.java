package com.basic.framework.dynamic.programming;

import com.basic.framework.structures.HashMap;
import com.basic.framework.structures.Map;

class FibonacciCalculation {

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    int recursiveFib(final int number) {
        int sum;

        if (number <= 2) {
            sum = 1;
        } else {
            sum = recursiveFib(number - 1) + recursiveFib(number - 2);
        }
        return sum;
    }

    int dynamicFib(final int number) {

        if (memo.get(number) != null) {
            return memo.get(number);
        }

        int sum;

        if (number <= 2) {
            sum = 1;
        } else {
            sum = dynamicFib(number - 1) + dynamicFib(number - 2);
        }

        memo.put(number, sum);
        return sum;

    }

}

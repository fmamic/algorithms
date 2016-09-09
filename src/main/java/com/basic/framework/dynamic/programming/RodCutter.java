package com.basic.framework.dynamic.programming;

class RodCutter {

    int optimalRodCutter(final int[] price, final int number) {
        if (number == 0) {
            return 0;
        }

        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= number; i++) {
            q = Math.max(q, price[i - 1] + optimalRodCutter(price, number - i));
        }

        return q;
    }

    int optimalRodCutterBottomUp(final int[] price, final int number) {
        final int[] revenue = new int[number + 1];

        for (int j = 1; j <= number; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, price[i - 1] + revenue[j - i]);
            }
            revenue[j] = q;
        }

        return revenue[number];
    }

}

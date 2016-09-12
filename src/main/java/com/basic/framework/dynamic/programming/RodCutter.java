package com.basic.framework.dynamic.programming;

import com.basic.framework.dynamic.programming.structures.RodCutterResult;

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

    RodCutterResult optimalRodCutterBottomUp(final int[] price, final int number) {
        final RodCutterResult result = new RodCutterResult();
        final int[] revenue = new int[number + 1];
        final int[] cutPiece = new int[number + 1];

        for (int j = 1; j <= number; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < price[i - 1] + revenue[j - i]) {
                    q = price[i - 1] + revenue[j - i];
                    cutPiece[j] = i;
                }
            }
            revenue[j] = q;
        }

        result.setOptimalCut(cutPiece);
        result.setRevenue(revenue[number]);

        return result;
    }

}

package com.basic.framework.dynamic.programming;

class CoinsSum {

    int minimumNumberOfCoins(final int[] coins, final int sum) {
        final int[] result = new int[sum + 1];

        result[0] = 0;

        for (int i = 1; i <= sum; i++) {
            int optimalNumber = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && optimalNumber > 1 + result[i - coins[j]]) {
                    optimalNumber = 1 + result[i - coins[j]];
                }
            }
            result[i] = optimalNumber;
        }

        return result[sum];
    }

}

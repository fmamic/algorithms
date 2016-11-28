package com.basic.framework.dynamic.programming;

/**
 * You are given two eggs, and access to a 100-storey building. Both eggs are identical. The aim is to find out the highest floor from which an egg
 * will not break when dropped out of a window from that floor. If an egg is dropped and does not break, it is undamaged and can be dropped again.
 * However, once an egg is broken, that’s it for that egg. If an egg breaks when dropped from floor n, then it would also have broken from any floor
 * above that. If an egg survives a fall, then it will survive any fall shorter than that. The question is: What strategy should you adopt to minimize
 * the number egg drops it takes to find the solution?
 */
class EggDrop {

    int calculateNaive(int eggs, int floors) {

        if (eggs == 1) {
            return floors;
        }

        if (floors < 2) {
            return floors;
        }

        int minimum = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int result = Math.max(calculateNaive(eggs - 1, k - 1), calculateNaive(eggs, floors - k));

            if (result < minimum) {
                minimum = result;
            }
        }

        return minimum + 1;
    }

    int calculateDP(int eggs, int floors) {
        final int[][] result = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= floors; i++) {
            result[1][i] = i;
        }

        for (int egg = 2; egg <= eggs; egg++) {
            for (int k = 1; k <= floors; k++) {
                if (k == 1 || k == 0) {
                    result[egg][k] = k;
                }
                else {
                    int minimum = Integer.MAX_VALUE;
                    for (int i = 1; i <= k; i++) {
                        int res = Math.max(result[egg - 1][i - 1], result[egg][k - i]);

                        if (res < minimum) {
                            minimum = res;
                        }
                    }
                    result[egg][k] = minimum + 1;

                }
            }
        }

        return result[eggs][floors];
    }

}

package com.leet.code;

import java.util.Arrays;

public class MaximumPointsInArray {

    int target = 0;
    int[] ans;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] result = new int[12];

        recursion(numArrows, aliceArrows, 0, result, 11);

        return ans;
    }

    public void recursion(int numArrows, int[] aliceArrows, int total, int[] result, int pointer) {

        if (numArrows <= 0 || pointer < 0) {
            if (total > target) {

                if (numArrows > 0) {
                    result[0] += numArrows;
                }

                target = total;
                ans = Arrays.copyOf(result, 12);
            }

            return;
        }

        int requiredArrows = aliceArrows[pointer] + 1;

        if (requiredArrows <= numArrows) {
            result[pointer] = requiredArrows;
            recursion(numArrows - requiredArrows, aliceArrows, total + pointer, result, pointer - 1);
            result[pointer] = 0;
        }

        recursion(numArrows, aliceArrows, total, result, pointer - 1);
    }
}

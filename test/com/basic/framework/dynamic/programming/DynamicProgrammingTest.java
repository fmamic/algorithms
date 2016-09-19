package com.basic.framework.dynamic.programming;

import com.basic.framework.dynamic.programming.structures.RodCutterResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicProgrammingTest {

    @Test
    public void fibonacciTest() {
        final FibonacciCalculation calculation = new FibonacciCalculation();

        // exponential running time
        assertEquals(1134903170, calculation.recursiveFib(45));
    }

    @Test
    public void fibonacciDTest() {
        final FibonacciCalculation calculation = new FibonacciCalculation();

        // linear running time
        assertEquals(1134903170, calculation.dynamicFib(45));
    }

    @Test
    public void rodCutter() {
        final RodCutter rodCutter = new RodCutter();
        final int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        assertEquals(30, rodCutter.optimalRodCutter(price, 10));
        assertEquals(18, rodCutter.optimalRodCutter(price, 7));
        assertEquals(5, rodCutter.optimalRodCutter(price, 2));

        final RodCutterResult result = rodCutter.optimalRodCutterBottomUp(price, 7);

        assertEquals(30, rodCutter.optimalRodCutterBottomUp(price, 10).getRevenue());
        assertEquals(18, rodCutter.optimalRodCutterBottomUp(price, 7).getRevenue());
        assertEquals(5, rodCutter.optimalRodCutterBottomUp(price, 2).getRevenue());

        System.out.println("Where to cut rod:");

        int number = 7;
        while (number > 0) {
            System.out.println(result.getOptimalCut()[number]);
            number = number - result.getOptimalCut()[number];
        }
    }

    @Test
    public void coinsSum() {
        final CoinsSum coinsSum = new CoinsSum();
        final int[] coins = new int[]{1, 3, 5};

        assertEquals(3, coinsSum.minimumNumberOfCoins(coins, 11));
        assertEquals(3, coinsSum.minimumNumberOfCoins(coins, 9));
        assertEquals(2, coinsSum.minimumNumberOfCoins(coins, 8));
        assertEquals(2, coinsSum.minimumNumberOfCoins(coins, 10));
    }

    @Test
    public void longestIncreasingSubsequenceTest() {
        final LongestSubsequence longestIncreasingSubsequence = new LongestSubsequence();

        final int[] sequence = new int[]{5, 3, 4, 8, 6, 7};

        assertEquals(4, longestIncreasingSubsequence.longestIncreasingSubsequence(sequence));
    }

    @Test
    public void maxMatrixSubSequence() {
        final Matrix matrix = new Matrix();
        final int[][] m = new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        assertEquals(2, matrix.maximumSizeSubMatrix(m));
    }

    @Test
    public void sumSubSequence() {
        final SubSetSum subSetSum = new SubSetSum();
        final int[] array = new int[]{1, 9, 2};

        assertEquals(true, subSetSum.findSubSetSum(array, 3));
        assertEquals(false, subSetSum.findSubSetSum(array, 22));

        assertEquals(true, subSetSum.findSubSetSumD(array, 3));
        assertEquals(false, subSetSum.findSubSetSumD(array, 22));
    }

    @Test
    public void editDistanceSequence() {
        final EditDistance editDistance = new EditDistance();
        final String str1 = "kitten";
        final String str2 = "sitting";

        assertEquals(3, editDistance.minimumEditDistanceNaive(str1, str2));
        assertEquals(3, editDistance.minimumEditDistance(str1, str2));
    }

    @Test
    public void findAllSubStrings() {
        final LongestSubsequence longestSubsequence = new LongestSubsequence();

        assertEquals("LCLC", longestSubsequence.findAllSubStrings("LCLC")[3]);
    }
}

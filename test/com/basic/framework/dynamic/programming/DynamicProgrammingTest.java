package com.basic.framework.dynamic.programming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.basic.framework.dynamic.programming.structures.MinumumJumps;
import com.basic.framework.dynamic.programming.structures.OptimalBST;
import com.basic.framework.dynamic.programming.structures.RodCutterResult;

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

    @Test
    public void longestCommonSubSequence() {
        final LongestSubsequence longestSubsequence = new LongestSubsequence();

        assertEquals(3, longestSubsequence.longestCommonSubSequenceNaive("LCLC", "CLCL"));
        assertEquals(3, longestSubsequence.longestCommonSubSequence("LCLC", "CLCL"));

        assertEquals(2, longestSubsequence.longestCommonSubSequenceNaive("SIR1", "STR2"));
        assertEquals(2, longestSubsequence.longestCommonSubSequence("SIR1", "STR2"));

        assertEquals("SR",
                longestSubsequence.longestCommonSubSequenceStr(longestSubsequence.longestCommonSubSequenceStr("SIR1", "STR2"), "SIR1", 4, 4));
    }

    @Test
    public void longestCommonSubString() {
        final LongestSubsequence longestSubsequence = new LongestSubsequence();

        // assertEquals(1, longestSubsequence.longestCommonSubStringNaive("SIR1", "STR2", 0));
        assertEquals(1, longestSubsequence.longestCommonSubString("SIR1", "STR2"));
    }

    @Test
    public void minimumNumberOfJumps() {
        final MinumumJumps minumumJumps = new MinumumJumps();
        final int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        assertEquals(3, minumumJumps.minJumpsNaive(array, 0, array.length - 1));
        assertEquals(3, minumumJumps.minJumpsMemoInvoke(array, 0, array.length - 1));
        assertEquals(3, minumumJumps.minJumpsDP(array));
        assertEquals(3, minumumJumps.minJumpsLinear(array));
    }

    @Test
    public void minimumNumberOfCutsTest() {
        final Palindrom palindrom = new Palindrom();
        final String str = "s12ss";
        final String str2 = "ana";

        assertEquals(3, palindrom.minimumCutsForPalindrom(str, 0, str.length() - 1));
        assertEquals(0, palindrom.minimumCutsForPalindrom(str2, 0, str2.length() - 1));

        assertEquals(3, palindrom.minimumCutsForPalindromMemo(str, 0, str.length() - 1));
        assertEquals(0, palindrom.minimumCutsForPalindromMemo(str2, 0, str2.length() - 1));
    }

    @Test
    public void optimalMatrixParenthesisTest() {
        final Matrix matrix = new Matrix();
        final int[] array = {10, 100, 5, 50};
        final int[] array2 = {30, 35, 15, 5, 10, 20, 25};

        assertEquals(7500, matrix.optParenthesizingR(array, 1, array.length - 1));
        assertEquals(7500, matrix.optParenthesizingNumber(array, 1, array.length - 1));

        assertEquals(15125, matrix.optParenthesizingR(array2, 1, array2.length - 1));
        assertEquals(15125, matrix.optParenthesizingNumber(array2, 1, array2.length - 1));

        assertEquals("((A1(A2A3))((A4A5)A6))",
                matrix.optParenthesizingStateStr(matrix.optParenthesizingState(array2, 1, array2.length - 1), 1, array2.length - 1));
    }

    @Test
    public void optimalBinarySearchTreeTest() {
        final double[][] array = new double[][]{{0, 0.15, 0.10, 0.05, 0.10, 0.20}, {0.05, 0.10, 0.05, 0.05, 0.05, 0.10}};

        final OptimalBinarySearchTree optBst = new OptimalBinarySearchTree();

        final Double result = optBst.optimalBinaryTreeCost(array, 1, array[0].length - 1);
        final OptimalBST resultD = optBst.optimalBinaryTreeCostD(array);

        assertEquals(true, result.equals(2.75));
        assertEquals(true, ((Double) resultD.getState()[1][array[0].length - 1]).equals(2.75));

        System.out.println(resultD.printTree(1, 5, resultD.getRoot()));
    }

    @Test
    public void binomialCoefTest() {
        final BinomialCoef binomialCoef = new BinomialCoef();

        assertEquals(10, binomialCoef.calculateNaive(5, 2));
        assertEquals(10, binomialCoef.calculateNaive(5, 3));

        assertEquals(10, binomialCoef.calculateDP(5, 2));
        assertEquals(10, binomialCoef.calculateDP(5, 3));
    }

    @Test
    public void knapsack01() {
        final Knapsack knapsack = new Knapsack();

        final int[] value = new int[]{5, 2, 4};
        final int[] weight = new int[]{2, 3, 2};

        assertEquals(9, knapsack.calculateNaive(value, weight, 4, 2));
    }
}

package com.leet.code;

import org.junit.Test;

import java.util.List;
import java.util.Set;

public class SolutionTest {

    @Test
    public void medianTest() {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{2, 3};

        final Solution solution = new Solution();
        solution.findMedianSortedArrays(a1, a2);
    }

    @Test
    public void threeSumClosest() {
        int[] a2 = new int[]{0, 1, 2};

        final Solution solution = new Solution();
        solution.threeSumClosest(a2, 0);
    }

    @Test
    public void threeSum() {
        int[] a2 = new int[]{-1, 0, 1, 2, -1, -4};

        final Solution solution = new Solution();
        solution.threeSum(a2);
    }

    @Test
    public void isValid() {
        final Solution solution = new Solution();
        solution.isValid("([])");
    }

    @Test
    public void firstMissingPositive() {
        final Solution solution = new Solution();
        solution.firstMissingPositive(new int[]{1, 2, 0});
    }

    @Test
    public void rotate() {
        final Solution solution = new Solution();
        solution.rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    @Test
    public void nQueens() {
        final Solution solution = new Solution();
        solution.totalNQueens(4);
    }

    @Test
    public void generateMatrix() {
        final Solution solution = new Solution();
        solution.generateMatrix(4);
    }

    @Test
    public void fullJustify() {
        final Solution solution = new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

    @Test
    public void largestRectangle() {
        final Solution solution = new Solution();
        solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    @Test
    public void numbersTest() {
        final Solution solution = new Solution();
        Set<List<Integer>> result = solution.numbers(2450);

        for (List<Integer> ints : result) {
            System.out.println(ints);
        }
    }
}

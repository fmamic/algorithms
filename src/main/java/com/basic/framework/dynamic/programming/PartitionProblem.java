package com.basic.framework.dynamic.programming;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 */
class PartitionProblem {

    boolean calculateNaive(final int[] array, final int index, final int sum) {

        if (sum == 0) {
            return true;
        }

        if (index == 0) {
            return false;
        }

        final int nextElement = index - 1;

        if (array[index] > sum) {
            return calculateNaive(array, nextElement, sum / 2);
        }

        return calculateNaive(array, nextElement, sum / 2) || calculateNaive(array, nextElement, (sum / 2) - array[index]);
    }

    boolean calculateDP() {

        return false;
    }

}

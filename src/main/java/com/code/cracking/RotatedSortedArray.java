package com.code.cracking;

/**
 * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2.
 * How would you find the minimum element? You may assume that the array has all unique elements.
 */
class RotatedSortedArray {

    int minRotatedArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int result = Integer.MAX_VALUE;

        if (high < 0) {
            return Integer.MIN_VALUE; // Infinity
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] < result) {
                result = array[mid];
            }

            if (array[mid] < array[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

}

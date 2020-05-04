package com.code.cracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RotatedSortedArrayTest {

    @Test
    public void rotatedSortedArrayTest() {
        int[] array1 = {6, 7, 8, 1, 2, 3, 4, 5};
        int[] array2 = {10, 12, 18, 25, 38, 3, 8, 9};
        int[] array3 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int[] array4 = {};
        int[] array5 = {1};

        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        int min1 = rotatedSortedArray.minRotatedArray(array1);
        int min2 = rotatedSortedArray.minRotatedArray(array2);
        int min3 = rotatedSortedArray.minRotatedArray(array3);
        int min4 = rotatedSortedArray.minRotatedArray(array4);
        int min5 = rotatedSortedArray.minRotatedArray(array5);

        assertEquals(1, min1);
        assertEquals(3, min2);
        assertEquals(1, min3);
        assertEquals(Integer.MIN_VALUE, min4);
        assertEquals(1, min5);
    }

}

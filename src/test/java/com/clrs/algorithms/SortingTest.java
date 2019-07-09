package com.clrs.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    @Test
    public void insertionSortTest() {
        Sorting sorting = new Sorting();

        int[] input = new int[]{2, 4, 5, 6, 3};
        sorting.insertionSort(input);

        assertEquals(2, input[0]);
        assertEquals(3, input[1]);
        assertEquals(4, input[2]);
        assertEquals(5, input[3]);
        assertEquals(6, input[4]);
    }

    @Test
    public void mergeProcedureTest() {
        Sorting sorting = new Sorting();

        int[] input = new int[]{1, 5, 8, 20, 3, 6, 21};
        sorting.merge(input, 0, 3, 6);

        assertEquals(1, input[0]);
        assertEquals(3, input[1]);
        assertEquals(5, input[2]);
        assertEquals(6, input[3]);
        assertEquals(8, input[4]);
        assertEquals(20, input[5]);
        assertEquals(21, input[6]);
    }

    @Test
    public void mergeSortTest() {
        Sorting sorting = new Sorting();

        int[] input = new int[]{1, 5, 20, 3, 6, 8, 21};
        sorting.mergeSort(input, 0, 6);

        assertEquals(1, input[0]);
        assertEquals(3, input[1]);
        assertEquals(5, input[2]);
        assertEquals(6, input[3]);
        assertEquals(8, input[4]);
        assertEquals(20, input[5]);
        assertEquals(21, input[6]);
    }
}
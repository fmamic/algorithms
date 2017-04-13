package com.basic.framework.structures;

import com.basic.framework.sort.HeapSort;
import com.basic.framework.structures.tree.Heap;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HeapTest {

    @Test
    public void heapTest() {
        final Heap heap = new Heap();
        final int[] array = {11, 2, 0, 22, 14, 10, 9};

        heap.buildMinHeap(array);

        assertEquals(7, heap.getHeapSize());
    }

    @Test
    public void heapSortTest() {
        final HeapSort heapSort = new HeapSort();

        final int[] array = {11, 2, 0, 22, 14, 10, 9};
        final int[] result = heapSort.heapSort(array);

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
        assertEquals(9, result[2]);
        assertEquals(10, result[3]);
        assertEquals(11, result[4]);
        assertEquals(14, result[5]);
        assertEquals(22, result[6]);
    }

}

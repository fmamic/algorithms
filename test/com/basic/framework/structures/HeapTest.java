package com.basic.framework.structures;

import com.basic.framework.sort.HeapSort;
import com.basic.framework.structures.tree.Heap;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HeapTest {

    @SuppressWarnings("unchecked")
    @Test
    public void heapTest() {
        final Heap heap = new Heap();
        final Integer[] array = {11, 2, 0, 22, 14, 10, 9};

        heap.buildMinHeap(array);

        assertEquals(6, heap.getHeapSize());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void heapIndexTest() {
        final Heap heap = new Heap();
        final Integer[] array = {11, 2, 0, 22, 14, 10, 9};

        heap.buildMinHeap(array);

        assertEquals(0, heap.getIndex(0));
        assertEquals(1, heap.getIndex(2));
        assertEquals(2, heap.getIndex(9));
        assertEquals(3, heap.getIndex(22));
        assertEquals(4, heap.getIndex(14));
        assertEquals(6, heap.getIndex(11));
        assertEquals(5, heap.getIndex(10));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void heapSortTest() {
        final HeapSort heapSort = new HeapSort();

        final Integer[] array = {11, 2, 0, 22, 14, 10, 9};
        final Integer[] result = (Integer[]) heapSort.heapSort(array);

        assertEquals((Integer) 0, result[0]);
        assertEquals((Integer) 2, result[1]);
        assertEquals((Integer) 9, result[2]);
        assertEquals((Integer) 10, result[3]);
        assertEquals((Integer) 11, result[4]);
        assertEquals((Integer) 14, result[5]);
        assertEquals((Integer) 22, result[6]);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void minHeapPriorityInsertTest() {
        final MinPriorityQueue minPriorityQueue = new MinPriorityQueue<Integer>(new Heap<Integer>());

        minPriorityQueue.insert(20);
        minPriorityQueue.insert(25);
        minPriorityQueue.insert(15);
        minPriorityQueue.insert(10);
        minPriorityQueue.insert(5);

        assertEquals(5, minPriorityQueue.getSize());

        assertEquals(5, minPriorityQueue.extractMin());
        assertEquals(10, minPriorityQueue.extractMin());
        assertEquals(15, minPriorityQueue.extractMin());
        assertEquals(20, minPriorityQueue.extractMin());
        assertEquals(25, minPriorityQueue.extractMin());
    }

}

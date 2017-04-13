package com.basic.framework.sort;

import com.basic.framework.structures.tree.Heap;

/**
 * Runs in O(NLogN) time - minHeapify runs in O(n)
 */
public class HeapSort {

    final Heap heap;

    public HeapSort() {
        heap = new Heap();
    }

    public int[] heapSort(final int[] array) {
        heap.buildMinHeap(array);

        final int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = heap.getRoot();

            heap.swap(0, heap.getHeapSize());
            heap.decreaseHeapSize();
            heap.minHeapify(0);
        }

        return result;
    }

}

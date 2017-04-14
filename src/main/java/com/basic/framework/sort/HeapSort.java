package com.basic.framework.sort;

import com.basic.framework.structures.tree.Heap;

import java.util.Arrays;

/**
 * Runs in O(NLogN) time - minHeapify runs in O(n)
 */
public class HeapSort<T extends Comparable> {

    final Heap<T> heap;

    public HeapSort() {
        heap = new Heap<T>();
    }

    @SuppressWarnings("unchecked")
    public T[] heapSort(final T[] array) {
        heap.buildMinHeap(array);

        final T[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = heap.getRoot();

            heap.swap(0, heap.getHeapSize());
            heap.decreaseHeapSize();
            heap.minHeapify(0);
        }

        return result;
    }

}

package com.basic.framework.structures;

import com.basic.framework.structures.tree.Heap;

public class MinPriorityQueue {

    private final Heap heap;

    public MinPriorityQueue(final Heap heap) {
        this.heap = heap;
    }

    public void insert(final int element) {
        heap.setKey(heap.getHeapSize(), Integer.MAX_VALUE);
        heap.increaseHeapSize();

        decreaseKey(heap.getHeapSize() - 1, element);
    }

    public int minimum() {
        return heap.getRoot();
    }

    public int getSize() {
        return heap.getHeapSize();
    }

    /**
     * Extract Minimum O(logN) running time
     * 
     * @return minimum from priority queue
     */
    public int extractMin() {
        if (heap.getHeapSize() < 1) {
            System.out.println("Heap size less then 1");
        }

        final int minimum = heap.getRoot();

        heap.swap(0, heap.getHeapSize() - 1);
        heap.decreaseHeapSize();
        heap.minHeapify(0);

        return minimum;
    }

    // Running in O(logN) time
    public void decreaseKey(int index, final int value) {
        if (value > heap.getKeyAtIndex(index)) {
            System.out.println("Value is bigger then current heap value");
            return;
        }

        heap.setKey(index, value);

        while (heap.parent(index) > heap.getKeyAtIndex(index)) {
            heap.swap(index, heap.getParentIndex(index));
            index = heap.getParentIndex(index);
        }
    }

}

package com.basic.framework.structures;

import com.basic.framework.structures.tree.Heap;

@SuppressWarnings("unchecked")
public class MinPriorityQueue<T extends Comparable> {

    private final Heap<T> heap;

    public MinPriorityQueue(final Heap<T> heap) {
        this.heap = heap;
    }

    public void insert(final T element) {
        heap.setKey(heap.getHeapSize(), element);
        heap.increaseHeapSize();

        decreaseKey(heap.getHeapSize() - 1, element);
    }

    public T minimum() {
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
    public T extractMin() {
        if (heap.getHeapSize() < 1) {
            System.out.println("Heap size less then 1");
        }

        final T minimum = heap.getRoot();

        heap.decreaseHeapSize();
        heap.swap(0, heap.getHeapSize());

        heap.minHeapify(0);

        return minimum;
    }

    // Running in O(logN) time
    public void decreaseKey(int index, final T value) {
        if (value.compareTo(heap.getKeyAtIndex(index)) > 0) {
            System.out.println("Value is bigger then current heap value");
            return;
        }

        heap.setKey(index, value);

        while (heap.parent(index).compareTo(heap.getKeyAtIndex(index)) > 0) {
            heap.swap(index, heap.getParentIndex(index));
            index = heap.getParentIndex(index);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
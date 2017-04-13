package com.basic.framework.structures.tree;

import java.util.Arrays;

/**
 * MIN-HEAP PROPERTY Heap data structure implemented with array root at 0. For more optimal performance array root should be at position 1 because
 * then most of CPUs can calculate position in one instruction.
 */
public class Heap {

    private int[] elements;
    private int heapSize = 0;

    public Heap() {
        elements = new int[10];
    }

    public Heap(int size) {
        elements = new int[size];
    }

    /**
     * Requires O(n) time for building Min-Priority heap from array of size N
     * @param array of integers
     */
    public int[] buildMinHeap(final int[] array) {
        elements = Arrays.copyOf(array, array.length);
        heapSize = array.length - 1;

        final int leafIndexStart = (heapSize / 2) - 1;
        for (int i = leafIndexStart; i >= 0; i--) {
            minHeapify(i);
        }

        return elements;
    }

    public void minHeapify(final int index) {
        if (index > heapSize)
            return;

        int smallest = index;
        if (getLeftIndex(index) <= heapSize && left(index) < elements[index]) {
            smallest = getLeftIndex(index);
        }

        if (getRightIndex(index) <= heapSize && right(index) < elements[smallest]) {
            smallest = getRightIndex(index);
        }

        if (smallest != index) {
            int temp = elements[index];
            elements[index] = elements[smallest];
            elements[smallest] = temp;

            minHeapify(smallest);
        }
    }

    public int getRoot() {
        return elements[0];
    }

    public void swap(final int index1, final int index2) {
        int temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public void decreaseHeapSize() {
        heapSize--;
    }

    public int getHeapSize() {
        return heapSize + 1;
    }

    private int getParentIndex(final int index) {
        return (index - 1) / 2;
    }

    private int parent(final int index) {
        return elements[getParentIndex(index)];
    }

    private int getLeftIndex(final int index) {
        return 2 * index + 1;
    }

    private int left(final int index) {
        return elements[getLeftIndex(index)];
    }

    private int getRightIndex(final int index) {
        return 2 * index + 2;
    }

    private int right(final int index) {
        return elements[getRightIndex(index)];
    }

}

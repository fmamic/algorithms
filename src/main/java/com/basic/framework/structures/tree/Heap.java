package com.basic.framework.structures.tree;

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

    public void minHeapify(final int index) {
        int left = left(index);
        int right = right(index);

        int smallest = index;
        if (left <= heapSize && left < elements[index]) {
            smallest = getLeftIndex(index);
        }

        if (right <= heapSize && right < elements[smallest]) {
            smallest = getRightIndex(index);
        }

        if (smallest != index) {
            int temp = elements[index];
            elements[index] = elements[smallest];
            elements[smallest] = temp;

            minHeapify(smallest);
        }
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

package com.basic.framework.structures.tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * MIN-HEAP PROPERTY Heap data structure implemented with array root at 0. For more optimal performance array root should be at position 1 because
 * then most of CPUs can calculate position in one instruction.
 */
@SuppressWarnings("unchecked")
public class Heap<T extends Comparable> {

    private final HashMap<T, Integer> indexMap = new HashMap<T, Integer>();

    private Object[] elements;
    private int heapSize = 0;

    public Heap() {
        elements = new Object[20];
    }

    public Heap(int size) {
        elements = new Object[size];
    }

    /**
     * Requires O(n) time for building Min-Priority heap from array of size N
     * 
     * @param array
     *            of integers
     */
    public T[] buildMinHeap(final T[] array) {
        elements = Arrays.copyOf(array, array.length);
        heapSize = array.length - 1;

        for (int i = 0; i < elements.length; i++) {
            indexMap.put((T) elements[i], i);
        }

        final int leafIndexStart = (heapSize / 2) - 1;
        for (int i = leafIndexStart; i >= 0; i--) {
            minHeapify(i);
        }

        return (T[]) elements;
    }

    public int getIndex(final T key) {
        return indexMap.get(key);
    }

    public void minHeapify(final int index) {
        if (index > heapSize)
            return;

        int smallest = index;
        if (getLeftIndex(index) <= heapSize && left(index).compareTo(elements[index]) < 0) {
            smallest = getLeftIndex(index);
        }

        if (getRightIndex(index) <= heapSize && right(index).compareTo(elements[smallest]) < 0) {
            smallest = getRightIndex(index);
        }

        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    public void setKey(final int index, final T key) {
        if (index < elements.length) {
            elements[index] = key;
            indexMap.put((T) elements[index], index);
        }
    }

    public T getKeyAtIndex(final int index) {
        if (index <= heapSize) {
            return (T) elements[index];
        }
        return null;
    }

    public boolean isEmpty() {
        return heapSize <= 0;
    }

    public T getRoot() {
        return (T) elements[0];
    }

    public void swap(final int index1, final int index2) {
        indexMap.put((T) elements[index1], index2);
        indexMap.put((T) elements[index2], index1);

        T temp = (T) elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public void increaseHeapSize() {
        heapSize++;
    }

    public void decreaseHeapSize() {
        heapSize--;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public T parent(final int index) {
        return (T) elements[getParentIndex(index)];
    }

    public int getParentIndex(final int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(final int index) {
        return 2 * index + 1;
    }

    private T left(final int index) {
        return (T) elements[getLeftIndex(index)];
    }

    private int getRightIndex(final int index) {
        return 2 * index + 2;
    }

    private T right(final int index) {
        return (T) elements[getRightIndex(index)];
    }

}

package com.basic.framework.structures;

import java.util.HashMap;

/**
 * Priority queue is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a "priority"
 * associated with it
 *
 * @param <E> must implement Comparable interface
 */
public class PriorityQueue<E extends Comparable> {

    private BinaryHeap<E> binaryHeap;

    public PriorityQueue() {
        binaryHeap = new BinaryHeap<E>();
    }

    public void insert(E object) {
        binaryHeap.insert(object);
    }

    public int getSize() {
        return binaryHeap.getSize();
    }

    // O(logN)
    public void decreaseKey(final E key, final E value) {
        binaryHeap.decreaseKey(key, value);
    }

    public HashMap<E, Integer> getIndexMap() {
        return (HashMap<E, Integer>) binaryHeap.getIndexMap();
    }

    public E getKey(final E key) {
        return binaryHeap.getKey(key);
    }

    public boolean contains(final E key) {
        return binaryHeap.contains(key);
    }

    public boolean isEmpty() {
        return binaryHeap.getSize() == 0;
    }

    public E extractMin() { // O(log n)
        E element = binaryHeap.findMinimum();
        binaryHeap.deleteMin();
        return element;
    }

}

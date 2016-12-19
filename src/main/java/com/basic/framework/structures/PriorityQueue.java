package com.basic.framework.structures;

/**
 * Priority queue is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a "priority"
 * associated with it
 * 
 * @param <E>
 *            must implement Comparable interface
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

    public E extractMin() {
        E element = binaryHeap.findMinimum();
        binaryHeap.deleteMin();
        return element;
    }

}

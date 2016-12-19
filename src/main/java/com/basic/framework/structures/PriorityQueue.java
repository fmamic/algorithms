package com.basic.framework.structures;

public class PriorityQueue<E extends Comparable> {

    private BinaryHeap<E> binaryHeap;

    public PriorityQueue() {
        binaryHeap = new BinaryHeap<E>();
    }

    public void insert(E object) {
        binaryHeap.insert(object);
    }

    public E extractMin() {
        E element = binaryHeap.findMinimum();
        binaryHeap.deleteMin();
        return element;
    }

}

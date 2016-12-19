package com.basic.framework.structures;

public class BinaryHeap<E extends Comparable> {

    private Object[] elements;

    private int size = 1;

    public BinaryHeap() {
        this.elements = new Object[10];
    }

    @SuppressWarnings("unchecked")
    public void insert(final E object) {
        elements[size] = object;

        if (size == 1) {
            size++;
            return;
        }

        int insertPosition = size;

        while (insertPosition > 1) {

            int parent = insertPosition / 2;
            if (((E) elements[parent]).compareTo(object) < 0) {
                break;
            }

            elements[insertPosition] = elements[parent];
            elements[parent] = object;
            insertPosition = parent;
        }

        size++;
    }

    public int getSize() {
        return this.size - 1;
    }
}

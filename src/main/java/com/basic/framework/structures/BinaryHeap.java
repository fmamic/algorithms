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

    @SuppressWarnings("unchecked")
    public E findMinimum() {
        return (E) elements[1];
    }

    @SuppressWarnings("unchecked")
    public void deleteMin() {  // O(log n)
        if (getSize() == 0) {
            return;
        }

        elements[1] = elements[getSize()];
        elements[getSize()] = null;
        size--;

        int position = 1;

        while (true) {
            int leftChild = 2 * position;
            int rightChild = 2 * position + 1;

            boolean isChildGreaterThenParent;

            if (elements[rightChild] == null && elements[leftChild] == null) {
                return;
            }

            if (elements[rightChild] == null) {
                isChildGreaterThenParent = ((E) elements[leftChild]).compareTo(elements[position]) < 0;
            }
            else if (elements[leftChild] == null) {
                isChildGreaterThenParent = ((E) elements[rightChild]).compareTo(elements[position]) < 0;
            }
            else {
                isChildGreaterThenParent = ((E) elements[leftChild]).compareTo(elements[position]) < 0
                        || ((E) elements[rightChild]).compareTo(elements[position]) < 0;
            }

            if (isChildGreaterThenParent) {
                if (elements[rightChild] == null || ((E) elements[leftChild]).compareTo(elements[rightChild]) < 0) {
                    E temp = (E) elements[leftChild];
                    elements[leftChild] = elements[position];
                    elements[position] = temp;
                    position = leftChild;
                }
                else if (elements[rightChild] != null) {
                    E temp = (E) elements[rightChild];
                    elements[rightChild] = elements[position];
                    elements[position] = temp;
                    position = rightChild;
                }
            }
            else {
                return;
            }
        }
    }

    public int getSize() {
        return this.size - 1;
    }
}

package com.basic.framework.structures;

import java.util.Map;
import java.util.HashMap;

public class BinaryHeap<E extends Comparable> {

    private Map<E, Integer> indexMap = new HashMap<E, Integer>();

    public Map<E, Integer> getIndexMap() {
        return this.indexMap;
    }

    private Object[] elements;

    private int size = 1;

    public BinaryHeap() {
        this.elements = new Object[10];
    }

    @SuppressWarnings("unchecked")
    public void insert(final E object) {
        elements[size] = object;
        indexMap.put(object, size);

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

            indexMap.put((E) elements[parent], insertPosition);
            indexMap.put(object, parent);

            elements[insertPosition] = elements[parent];
            elements[parent] = object;

            insertPosition = parent;
        }

        size++;
    }

    public E getKey(final E key) {
        for (final E keyIter : indexMap.keySet()) {
            if (key.equals(keyIter)) {
                return keyIter;
            }
        }

        return null;
    }

    // O(1)
    public boolean contains(final E key) {
        return indexMap.containsKey(key);
    }

    // average: O(1)
    private Integer searchIndex(final E key) {
        return indexMap.get(key);
    }

    // average: O(logn)
    @SuppressWarnings("unchecked")
    public void decreaseKey(final E key, E value) {
        final Integer index = indexMap.get(key);
        elements[index] = value;

        indexMap.remove(key);
        indexMap.put(value, index);

        int insertPosition = index;

        while (insertPosition > 1) {

            int parent = insertPosition / 2;

            if (((E) elements[parent]).compareTo(value) < 0) {
                break;
            }

            indexMap.put((E) elements[parent], insertPosition);
            indexMap.put(value, parent);

            elements[insertPosition] = elements[parent];
            elements[parent] = value;

            insertPosition = parent;
        }

    }

    // O(1)
    @SuppressWarnings("unchecked")
    public E findMinimum() {
        return (E) elements[1];
    }

    @SuppressWarnings("unchecked")
    public void deleteMin() {  // O(log n)
        if (getSize() == 0) {
            return;
        }

        // update index map by removing minimum element
        indexMap.remove((E) elements[1]);
        indexMap.put((E) elements[getSize()], 1);

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
            } else if (elements[leftChild] == null) {
                isChildGreaterThenParent = ((E) elements[rightChild]).compareTo(elements[position]) < 0;
            } else {
                isChildGreaterThenParent = ((E) elements[leftChild]).compareTo(elements[position]) < 0
                        || ((E) elements[rightChild]).compareTo(elements[position]) < 0;
            }

            if (isChildGreaterThenParent) {
                if (elements[rightChild] == null || ((E) elements[leftChild]).compareTo(elements[rightChild]) < 0) {

                    indexMap.put((E) elements[leftChild], position);
                    indexMap.put((E) elements[position], leftChild);

                    E temp = (E) elements[leftChild];
                    elements[leftChild] = elements[position];
                    elements[position] = temp;


                    position = leftChild;
                } else if (elements[rightChild] != null) {

                    indexMap.put((E) elements[rightChild], position);
                    indexMap.put((E) elements[position], rightChild);

                    E temp = (E) elements[rightChild];
                    elements[rightChild] = elements[position];
                    elements[position] = temp;

                    position = rightChild;
                }
            } else {
                return;
            }
        }
    }

    public int getSize() {
        return this.size - 1;
    }
}

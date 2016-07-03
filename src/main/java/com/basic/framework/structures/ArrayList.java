package com.basic.framework.structures;

public class ArrayList<E> extends Vector implements List<E> {

    private int size = 0;

    public ArrayList() {
        super(10);
    }

    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public void add(E element) {
        elements[size++] = element;
    }

    public void add(final int index, final E element) {
        elements[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
    }

    public boolean contains(E element) {
        for (Object object : elements) {
            if (element.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public void delete(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                for (int k = i; k < size; k++) {
                    elements[k] = elements[k + 1];
                }
                elements[size] = null;
                size--;
                return;
            }
        }
    }

    public void delete() {
        elements[size] = null;
        size--;
    }

    public int size() {
        return size;
    }
}

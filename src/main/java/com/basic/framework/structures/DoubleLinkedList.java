package com.basic.framework.structures;

public class DoubleLinkedList<E> implements List<E> {

    private transient int size = 0;

    private Node<E> first;

    private Node<E> last;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(element, first, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.element;
    }

    public E get(final E element) {
        Node<E> result = first;
        for (int i = 0; i < size(); i++) {
            if (result.element.equals(element)) {
                return result.element;
            }
            result = result.next;
        }

        return null;
    }

    public boolean contains(E element) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (element.equals(node.element)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public void delete(E element) {
        if (first.element.equals(element)) {
            if (first.next != null) {
                first = first.next;
                first.prev = null;
            } else {
                last = null;
                first = null;
            }
            size--;
            return;
        }

        if (last.element.equals(element)) {
            if (last.prev != null) {
                last = last.prev;
                last.next = null;
            } else {
                last = null;
            }
            size--;
            return;
        }

        for (Node<E> node = first; node != null; node = node.next) {
            if (element.equals(node.element)) {

                if (node.next != null)
                    node.next.prev = node.prev;
                if (node.prev != null)
                    node.prev.next = node.next;

                size--;
                return;
            }
        }
    }

    public void delete() {
        Node<E> node = last.prev;

        last.prev = null;
        node.next = null;

        last = node;
        size--;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(final E element, final Node<E> prev, final Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}

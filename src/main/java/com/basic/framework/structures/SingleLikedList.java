package com.basic.framework.structures;

public class SingleLikedList<E> implements List<E> {

    private Node<E> first;

    private Node<E> last;

    private int size = 0;

    public static class Node<E> {
        private Node<E> next;
        private E element;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void add(E element) {
        final Node<E> node = new Node<E>(element, null);

        if (first == null) {
            first = node;
        } else if (last == null) {
            last = node;
            first.next = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public E get(int index) {
        Node<E> node = first;

        for (int i = 1; i < size && i <= index; i++) {
            node = node.next;
        }

        return node.element;
    }

    public boolean contains(E element) {
        for (Node<E> node = first; node != null; node = first.next) {
            if (node.element.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void delete(E element) {

    }

    public void delete() {
        Node<E> node = first;

        for (int i = 0; i < size - 2; i++) {
            node = node.next;
        }

        last = node;
        node.next = null;

        size--;
    }

    public int size() {
        return size;
    }
}

package com.basic.framework.structures;

import com.basic.framework.exception.EmptyQueueException;
import com.basic.framework.exception.QueueOutOfSpaceException;

public class Queue<E> extends Vector {

    private int head = 0;

    private int tail = 0;

    public Queue() {
        super(10);
    }

    public Queue(final int initialCapacity) {
        super(initialCapacity);
    }

    public void enqueue(final E element) {
        if (tail == elements.length && head != 0) {
            elements[tail] = element;
            tail = 0;
        } else if(tail != elements.length) {
            elements[tail] = element;
            tail++;
        } else {
            throw new QueueOutOfSpaceException();
        }
    }

    public E dequeue() {
        @SuppressWarnings("unchecked")
        final E element = (E) elements[head];

        if(head == elements.length) {
            head = 0;
        } else {
            head++;
        }

        return element;
    }

    public int size() {
        return Math.abs(head - tail);
    }
}

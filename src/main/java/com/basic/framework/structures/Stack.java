package com.basic.framework.structures;

public class Stack<T> extends Vector {

    private int top = 0;

    public Stack() {
        super(10);
    }

    public Stack(final int initialCapacity) {
        super(initialCapacity);
    }

    public void push(final T object) {
        elements[top++] = object;
    }

    public T pop() {
        if (isEmpty())
            return null;

        @SuppressWarnings("unchecked")
        final T result = (T) elements[--top];

        elements[top] = null;
        return result;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (final Object object : elements) {
            if (object != null) {
                stringBuilder.append(object.toString());
            }
        }

        return stringBuilder.toString();
    }
}

package com.basic.framework.structures;

public interface List<E> {

    void add(E element);

    E get(int index);

    boolean contains(E element);

    void delete(E element);

    void delete();

    int size();
}

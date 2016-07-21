package com.basic.framework.structures;

public interface Tree<T> {

    interface Node<T> {

        T getData();

        boolean equals(Object o);

        int hashCode();

    }
}

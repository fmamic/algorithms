package com.basic.framework.structures;

public abstract class SearchTree<T extends Comparable<T>> implements Tree<T> {

    public SearchTree(final T data) {
        initRoot(data);
    }

    public abstract T insert(final T data);

    public abstract boolean search(final T data);

    public abstract T minimum();

    public abstract T maximum();

    public abstract T successor(T data);

    public abstract T predecessor(T data);

    public abstract void delete(T data);

    protected abstract void initRoot(final T data);

}

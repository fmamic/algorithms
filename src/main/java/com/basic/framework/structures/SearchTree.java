package com.basic.framework.structures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

abstract class SearchTree<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    SearchTree(final T data) {
        initRoot(data);
    }

    public abstract T insert(final T data);

    public abstract boolean search(final T data);

    public T minimum() {
        return treeMinimum(this.root).getData();
    }

    public abstract T maximum();

    public abstract T successor(T data);

    public abstract T predecessor(T data);

    public abstract void delete(T data);

    protected abstract void initRoot(final T data);

    abstract Node<T> treeMinimum(final Node<T> node);

    static class Node<T extends Comparable<T>> implements Tree.Node<T> {
        private T data;

        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public T getData() {
            return this.data;
        }

        Node(final T data, final Node<T> parent, final Node<T> left, final Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public boolean equals(final Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            final Node<?> node = (Node<?>) o;

            return new EqualsBuilder().append(getData(), node.getData()).isEquals();
        }

        public int hashCode() {
            return new HashCodeBuilder().append(data).build();
        }
    }
}

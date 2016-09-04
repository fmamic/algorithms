package com.basic.framework.structures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

abstract class SearchTree<T extends Comparable<T>> implements Tree<T> {

    SearchTree(final T data) {
        initRoot(data);
    }

    public abstract T insert(final T data);

    public abstract boolean search(final T data);

    public T minimum() {
        return treeMinimum(getRoot()).getData();
    }

    public T maximum() {
        return treeMaximum(getRoot()).getData();
    }

    public T successor(final T data) {
        return treeSuccessor(treeSearch(getRoot(), data)).getData();
    }

    public T predecessor(final T data) {
        return treePredecessor(treeSearch(getRoot(), data)).getData();
    }

    public abstract void delete(final T data);

    protected abstract void initRoot(final T data);

    abstract Node<T> treeMinimum(final Node<T> node);

    abstract Node<T> treeMaximum(final Node<T> node);

    abstract Node<T> treeSuccessor(final Node<T> data);

    abstract Node<T> treePredecessor(final Node<T> data);

    abstract Node<T> treeSearch(final Node<T> node, final T data);

    abstract Node<T> getRoot();

    static class Node<T extends Comparable<T>> implements Tree.Node<T> {
        private T data;

        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public T getData() {
            return this.data;
        }

        void setData(final T data) {
            this.data = data;
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

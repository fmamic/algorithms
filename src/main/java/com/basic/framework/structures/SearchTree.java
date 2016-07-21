package com.basic.framework.structures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    protected static class Node<T extends Comparable<T>> implements Tree.Node<T> {
        private T data;

        protected Node<T> parent;
        protected Node<T> left;
        protected Node<T> right;

        public T getData() {
            return this.data;
        }

        public Node(final T data, final Node<T> parent, final Node<T> left, final Node<T> right) {
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

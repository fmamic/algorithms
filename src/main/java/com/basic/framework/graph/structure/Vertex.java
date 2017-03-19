package com.basic.framework.graph.structure;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T extends Comparable> implements Comparable {

    private final List<Vertex> adjacency = new ArrayList<Vertex>();

    private T key;

    private Vertex prev = null;

    private Depth depth = new Depth();

    private Breadth breadth = new Breadth();

    public T getKey() {
        return this.key;
    }

    public void setKey(final T key) {
        this.key = key;
    }

    @SuppressWarnings("unchecked")
    public int compareTo(final Object o) {
        return ((Vertex) o).getKey().compareTo(this.key);
    }

    public Depth getDepth() {
        return depth;
    }

    public Breadth getBreadth() {
        return breadth;
    }

    public List<Vertex> getAdjacency() {
        return adjacency;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setPrev(final Vertex prev) {
        this.prev = prev;
    }
}

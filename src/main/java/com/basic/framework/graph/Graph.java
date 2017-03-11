package com.basic.framework.graph;

import com.basic.framework.graph.structure.Vertex;

import java.util.List;

public abstract class Graph<T extends Comparable> {

    private int numEdges = 0;

    public int getNumEdges() {
        return numEdges;
    }

    public Vertex addVertex(final T key) {
        return implementAddVertex(key);
    }

    public void addEdgeByKey(final T source, final T destination) {
        numEdges++;
        implementAddEdgeWithKey(source, destination);
    }

    public void addEdge(final Vertex source, final Vertex destination) {
        numEdges++;
        implementAddEdge(source, destination);
    }

    protected abstract void implementAddEdge(final Vertex source, final Vertex destination);

    protected abstract void implementAddEdgeWithKey(final T sourceKey, final T destinationKey);

    protected abstract Vertex implementAddVertex(T key);

    protected abstract List<Vertex> getNeighbours(final Vertex vertex);
}

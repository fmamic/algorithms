package com.basic.framework.graph;

import com.basic.framework.graph.structure.Vertex;

import java.util.List;

public abstract class Graph {

    private int numVertices = 0;
    private int numEdges = 0;

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public Vertex addVertex() {
        numVertices++;
        return implementAddVertex();
    }

    public void addEdge(final Vertex source, final Vertex destination) {
        numEdges++;
        implementAddEdge(source, destination);
    }

    protected abstract void implementAddEdge(final Vertex source, final Vertex destination);

    protected abstract Vertex implementAddVertex();

    protected abstract List<Vertex> getNeighbours(final Vertex vertex);
}

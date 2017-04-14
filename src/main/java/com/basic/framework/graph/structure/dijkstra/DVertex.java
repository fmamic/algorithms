package com.basic.framework.graph.structure.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DVertex {

    private int key;

    private int distance = Integer.MAX_VALUE;

    private DVertex previous;

    private List<DEdge> edges = new ArrayList<DEdge>();

    public List<DVertex> getAdjacencies() {
        final List<DVertex> vertices = new ArrayList<DVertex>();

        for (final DEdge edge : edges) {
            vertices.add(edge.getDestination());
        }

        return vertices;
    }

    public DEdge getEdgeWithDestKey(final int key) {
        for (final DEdge edge : edges) {
            if (edge.getDestination().getKey() == key) {
                return edge;
            }
        }
        return null;
    }

    public void addEdge(final DEdge edge) {
        edges.add(edge);
    }

    public List<DEdge> getEdges() {
        return edges;
    }

    public void setEdges(final List<DEdge> edges) {
        this.edges = edges;
    }

    public DVertex getPrevious() {
        return previous;
    }

    public void setPrevious(final DVertex previous) {
        this.previous = previous;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public int getKey() {
        return key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final DVertex vertex = (DVertex) o;

        return key == vertex.key;
    }

    @Override
    public int hashCode() {
        return key;
    }
}

package com.basic.framework.graph.impl;

import com.basic.framework.graph.Graph;
import com.basic.framework.graph.structure.Edge;
import com.basic.framework.graph.structure.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
public class GraphList<T extends Comparable> extends Graph<T> {

    private final HashMap<T, Vertex> vertices = new HashMap<T, Vertex>();

    private final List<Edge> edges = new ArrayList<Edge>();

    public int getVertexNumber() {
        return vertices.size();
    }

    public HashMap<T, Vertex> getVertices() {
        return this.vertices;
    }

    public Vertex getVertex(final T key) {
        return this.vertices.get(key);
    }

    protected Vertex implementAddVertex(final T key) {
        final Vertex vertex = new Vertex();
        vertex.setKey(key);
        vertices.put(key, vertex);

        return vertex;
    }

    protected void implementAddEdgeWithKey(final T sourceKey, final T destinationKey) {
        final Vertex source = vertices.get(sourceKey);
        final Vertex destination = vertices.get(destinationKey);

        source.getAdjacency().add(destination);
    }

    protected void implementAddEdge(final Vertex source, final Vertex destination) {
        source.getAdjacency().add(destination);
    }

    // bidirectional edge
    public void addEdgeWithWeight(final T source, final T destination, final int weight) {
        final Vertex vertexSource = vertices.get(source);
        final Vertex vertexDestination = vertices.get(destination);

        vertexSource.getAdjacency().add(destination);

        final Edge edge = new Edge();
        edge.setSource(vertexSource);
        edge.setDestination(vertexDestination);
        edge.setWeight(weight);

        edges.add(edge);
    }

    public List<Vertex> getNeighbours(final Vertex vertex) {
        return vertex.getAdjacency();
    }

    public void printBreadthShortestPath(final Vertex start, final Vertex end) {
        if (start.getKey().equals(end.getKey())) {
            System.out.println(start.getKey());
        } else if (end.getBreadth().getPredecessor() == null) {
            System.out.println("No path available from " + start.getKey() + " to " + end.getKey());
        } else {
            printBreadthShortestPath(start, end.getBreadth().getPredecessor());
            System.out.println(end.getKey());
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }
}


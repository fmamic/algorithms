package com.basic.framework.graph.structure.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DGraph {

    private final List<DVertex> vertices = new ArrayList<DVertex>();

    private final List<DEdge> edges = new ArrayList<DEdge>();

    public void addVertex(final DVertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(final int source, final int destination, final int weight) {
        DVertex vertexSource = new DVertex();
        vertexSource.setKey(source);

        if (!vertices.contains(vertexSource)) {
            vertices.add(vertexSource);
        } else {
            vertexSource = vertices.get(vertices.indexOf(vertexSource));
        }

        DVertex vertexDestination = new DVertex();
        vertexDestination.setKey(destination);

        if (!vertices.contains(vertexDestination)) {
            vertices.add(vertexDestination);
        } else {
            vertexDestination = vertices.get(vertices.indexOf(vertexDestination));
        }

        final DEdge dEdge = new DEdge();

        dEdge.setSource(vertexSource);
        dEdge.setDestination(vertexDestination);
        dEdge.setWeight(weight);

        vertexSource.addEdge(dEdge);
    }

    public void addEdge(final DVertex source, final DVertex destination, final int weight) {
        if (!vertices.contains(source)) {
            vertices.add(source);
        }

        if (!vertices.contains(destination)) {
            vertices.add(destination);
        }

        final DEdge dEdge = new DEdge();

        dEdge.setSource(source);
        dEdge.setDestination(destination);
        dEdge.setWeight(weight);

        source.addEdge(dEdge);
    }

    public DVertex getVertex(final int key) {
        for (final DVertex vertex : vertices) {
            if (key == vertex.getKey()) {
                return vertex;
            }
        }
        return null;
    }

    public List<DVertex> getVertices() {
        return vertices;
    }

    public List<DEdge> getEdges() {
        return edges;
    }
}

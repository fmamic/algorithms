package com.basic.framework.graph.impl;

import com.basic.framework.graph.Graph;
import com.basic.framework.graph.structure.Edge;
import com.basic.framework.graph.structure.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrapAdjList extends Graph {

    final Map<Vertex, ArrayList<Vertex>> adjListMap = new HashMap<Vertex, ArrayList<Vertex>>();

    protected Vertex implementAddVertex() {
        final Vertex vertex = new Vertex();
        vertex.setKey(getNumVertices());

        adjListMap.put(vertex, new ArrayList<Vertex>());

        return vertex;
    }

    protected void implementAddEdge(final Vertex source, final Vertex destination) {
        final Edge edge = new Edge();
        edge.setWeight(0);
        edge.setSource(source);
        edge.setDestination(destination);

        adjListMap.get(source).add(destination);

        source.getEdges().add(edge);
    }

    public ArrayList<Vertex> getNeighbours(final Vertex vertex) {
        return adjListMap.get(vertex);
    }

    public void printShortestPath(final Vertex start, final Vertex end) {
        if (start.getKey().equals(end.getKey())) {
            System.out.println(start.getKey());
        } else if (end.getPredecessor() == null) {
            System.out.println("No path available from " + start.getKey() + " to " + end.getKey());
        } else {
            printShortestPath(start, end.getPredecessor());
            System.out.println(end.getKey());
        }
    }
}


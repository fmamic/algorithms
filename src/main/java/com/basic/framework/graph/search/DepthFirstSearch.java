package com.basic.framework.graph.search;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;

public class DepthFirstSearch {

    private static int time = 0;
    private Stack<Vertex> topologicalSort = new Stack<Vertex>();

    @SuppressWarnings("unchecked")
    public Stack<Vertex> search(final GraphList graph) {
        time = 0;
        for (final Object vertex : graph.getVertices().values()) {
            final Vertex vert = (Vertex) vertex;
            if (vert.getDepth().getColor().equals(Color.WHITE)) {
                visit(vert);
            }
        }

        return topologicalSort;
    }

    @SuppressWarnings("unchecked")
    private void visit(final Vertex vertex) {
        time++;
        vertex.getDepth().setColor(Color.GRAY);
        vertex.getDepth().setStartTime(time);

        final List<Vertex> neighbours = vertex.getAdjacency();
        for (final Vertex neighbour : neighbours) {
            if (neighbour.getDepth().getColor().equals(Color.WHITE)) {
                neighbour.getDepth().setPredecessor(vertex);
                visit(neighbour);
            }
        }

        time++;
        vertex.getDepth().setColor(Color.BLACK);
        vertex.getDepth().setEndTime(time);
        topologicalSort.push(vertex);
    }

    @SuppressWarnings("unchecked")
    public GraphList reverseEdge(final GraphList graph) {
        final GraphList reverseGraph = new GraphList();

        final Collection vertices = graph.getVertices().values();
        for (final Object vertex : vertices) {
            final Vertex vert = (Vertex) vertex;
            reverseGraph.addVertex(vert.getKey());
        }

        for (final Object vertex : vertices) {
            final Vertex vert = (Vertex) vertex;
            final Vertex reverseVert = reverseGraph.getVertex(vert.getKey());

            for (final Object adj : vert.getAdjacency()) {
                final Vertex adjVert = (Vertex) adj;
                final Vertex adjReverse = reverseGraph.getVertex(adjVert.getKey());

                reverseGraph.addEdge(adjReverse, reverseVert);
            }
        }
        return reverseGraph;
    }

}

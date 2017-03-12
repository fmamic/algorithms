package com.basic.framework.graph.search;

import com.basic.framework.graph.Graph;
import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

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
    public void reverseEdge(final GraphList graph) {
        final Collection vertices = graph.getVertices().values();
        for (final Object vertex : vertices) {
            final Vertex vert = (Vertex) vertex;

            final List<Vertex> removeAdj = new ArrayList<Vertex>();
            for (final Object adj : vert.getAdjacency()) {
                final Vertex adjVert = (Vertex) adj;
                adjVert.getAdjacency().add(vert);
                removeAdj.add(adjVert);
            }
            vert.getAdjacency().removeAll(removeAdj);
        }
    }

}

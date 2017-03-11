package com.basic.framework.graph.search;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;

import java.util.List;

public class DepthFirstSearch {

    private static int time = 0;

    @SuppressWarnings("unchecked")
    public void search(final GraphList graph) {
        time = 0;
        for (final Object vertex : graph.getVertices().values()) {
            final Vertex vert = (Vertex) vertex;
            if (vert.getDepth().getColor().equals(Color.WHITE)) {
                visit(vert);
            }
        }
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
    }

}

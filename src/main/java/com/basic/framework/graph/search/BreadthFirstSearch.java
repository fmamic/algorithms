package com.basic.framework.graph.search;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;
import com.basic.framework.structures.PriorityQueue;

import java.util.List;

public class BreadthFirstSearch {

    @SuppressWarnings("unchecked")
    public void search(final GraphList graph, final Vertex source) {
        final PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        Vertex vertex = source;

        while (vertex != null) {
            vertex.getBreadth().setStatus(Color.GRAY);

            if (vertex.getBreadth().getStatus().equals(Color.WHITE)) {
                vertex.getBreadth().setPredecessor(null);
                vertex.getBreadth().setDistance(0);
            }

            final List<Vertex> neighbours = graph.getNeighbours(vertex);
            for (final Vertex adjVertex : neighbours) {
                if (!adjVertex.getBreadth().getStatus().equals(Color.GRAY) && !adjVertex.getBreadth().getStatus().equals(Color.BLACK)) {
                    adjVertex.getBreadth().setStatus(Color.GRAY);
                    adjVertex.getBreadth().setDistance(vertex.getBreadth().getDistance() + 1);
                    adjVertex.getBreadth().setPredecessor(vertex);

                    queue.insert(adjVertex);
                }
            }

            vertex.getBreadth().setStatus(Color.BLACK);
            vertex = queue.extractMin();
        }
    }

}

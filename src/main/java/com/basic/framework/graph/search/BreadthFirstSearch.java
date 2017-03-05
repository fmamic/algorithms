package com.basic.framework.graph.search;

import com.basic.framework.graph.impl.GrapAdjList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;
import com.basic.framework.structures.PriorityQueue;

public class BreadthFirstSearch {

    public void search(final GrapAdjList graph, final Vertex source) {
        final PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        Vertex vertex = source;

        while (vertex != null) {
            vertex.setStatus(Color.GRAY);

            if (vertex.getStatus().equals(Color.WHITE)) {
                vertex.setPredecessor(null);
                vertex.setDistance(0);
            }

            for (final Vertex adjVertex : graph.getNeighbours(vertex)) {
                if (!adjVertex.getStatus().equals(Color.GRAY) && !adjVertex.getStatus().equals(Color.BLACK)) {
                    adjVertex.setStatus(Color.GRAY);
                    adjVertex.setDistance(vertex.getDistance() + 1);
                    adjVertex.setPredecessor(vertex);

                    queue.insert(adjVertex);
                }
            }

            vertex.setStatus(Color.BLACK);
            vertex = queue.extractMin();
        }
    }

}

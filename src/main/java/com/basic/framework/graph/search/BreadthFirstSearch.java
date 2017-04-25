package com.basic.framework.graph.search;

import java.util.List;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;
import com.basic.framework.structures.PriorityQueue;

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

    @SuppressWarnings("unchecked")
    public void searchJavaQueue(final GraphList graph, final Vertex source) {
        final java.util.PriorityQueue<Vertex> queue = new java.util.PriorityQueue<Vertex>();

        source.getBreadth().setStatus(Color.GRAY);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            final List<Vertex> neighbours = graph.getNeighbours(current);
            for (final Vertex adj : neighbours) {
                if (adj.getBreadth().getStatus().equals(Color.WHITE)) {
                    adj.getBreadth().setStatus(Color.GRAY);
                    adj.getBreadth().setDistance(current.getBreadth().getDistance() + 1);
                    adj.getBreadth().setPredecessor(current);

                    queue.add(adj);
                }
            }
            current.getBreadth().setStatus(Color.BLACK);
        }
    }

}

package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.structure.dijkstra.DGraph;
import com.basic.framework.graph.structure.dijkstra.DVertex;
import com.basic.framework.graph.structure.dijkstra.DVertexQueue;
import com.basic.framework.structures.HashMap;
import com.basic.framework.structures.MinPriorityQueue;
import com.basic.framework.structures.tree.Heap;

public class DijkstraAlgorithm {

    private HashMap<DVertex, Integer> map = new HashMap<DVertex, Integer>();

    private MinPriorityQueue minPriorityQueue = new MinPriorityQueue<DVertexQueue>(new Heap<DVertexQueue>());

    public void initializeSingleSource(final DGraph graph, final DVertex source) {
        source.setDistance(0);
    }

    public void relaxation(final DVertex source, final DVertex destination) {
        final int distance = source.getDistance() + source.getEdgeWithDestKey(destination.getKey()).getWeight();

        if (destination.getDistance() > distance) {
            destination.setDistance(distance);
            destination.setPrevious(source);
        }
    }

    @SuppressWarnings("unchecked")
    public void algorithm(final DGraph graph, final DVertex source) {
        initializeSingleSource(graph, source);

        for (final DVertex vertex : graph.getVertices()) {
            final DVertexQueue queueVertex = new DVertexQueue();
            queueVertex.setDistance(vertex.getDistance());
            queueVertex.setKey(vertex.getKey());

            minPriorityQueue.insert(queueVertex);
        }

        while (!minPriorityQueue.isEmpty()) {
            final DVertexQueue vertex = (DVertexQueue) minPriorityQueue.extractMin();
            final DVertex dVertex = graph.getVertex(vertex.getKey());

            map.put(dVertex, vertex.getDistance());

            for (DVertex adj : dVertex.getAdjacencies()) {
                relaxation(dVertex, adj);
            }
        }
    }

}

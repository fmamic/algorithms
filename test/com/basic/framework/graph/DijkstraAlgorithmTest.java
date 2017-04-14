package com.basic.framework.graph;

import static junit.framework.Assert.assertEquals;

import com.basic.framework.graph.algorithm.DijkstraAlgorithm;
import com.basic.framework.graph.structure.dijkstra.DGraph;

import org.junit.Test;

public class DijkstraAlgorithmTest {

    @Test
    public void dijkstraAlgorithmTest() {
        final DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        final DGraph dGraph = new DGraph();

        dGraph.addEdge(0, 3, 3);
        dGraph.addEdge(0, 5, 5);
        dGraph.addEdge(5, 3, 1);
        dGraph.addEdge(3, 5, 2);
        dGraph.addEdge(3, 9, 6);
        dGraph.addEdge(5, 11, 6);
        dGraph.addEdge(11, 0, 3);
        dGraph.addEdge(11, 9, 7);
        dGraph.addEdge(9, 11, 2);

        dijkstraAlgorithm.algorithm(dGraph, dGraph.getVertex(0));

        assertEquals(9, dGraph.getVertex(9).getDistance());
    }
}

package com.basic.framework.graph;

import static org.junit.Assert.assertNotNull;

import com.basic.framework.graph.algorithm.AllPairsShortestPath;

import org.junit.Test;

public class AllPairsShortestPathTest {
 
    @Test
    public void allParisShortestPathTest() {
        GraphMatrix graphMarix = new GraphMatrix(4);

        graphMarix.addEdge(0, 1, 3);
        graphMarix.addEdge(0, 2, 8);
        graphMarix.addEdge(0, 4, -4);
        graphMarix.addEdge(1, 3, 1);
        graphMarix.addEdge(1, 4, 7);
        graphMarix.addEdge(2, 1, 4);
        graphMarix.addEdge(3, 2, -5);
        graphMarix.addEdge(3, 0, 2);
        graphMarix.addEdge(4, 3, 6);

        AllPairsShortestPath allPairsShortestPath = new AllPairsShortestPath();

        int[][][] result = allPairsShortestPath.allPairShortestPath(graphMarix);

        assertNotNull(result);
    }

    @Test
    public void allPairsShortestPathSlow() {
        GraphMatrix graphMarix = new GraphMatrix(4);

        graphMarix.addEdge(0, 1, 3);
        graphMarix.addEdge(0, 2, 8);
        graphMarix.addEdge(0, 4, -4);
        graphMarix.addEdge(1, 3, 1);
        graphMarix.addEdge(1, 4, 7);
        graphMarix.addEdge(2, 1, 4);
        graphMarix.addEdge(3, 2, -5);
        graphMarix.addEdge(3, 0, 2);
        graphMarix.addEdge(4, 3, 6);

        AllPairsShortestPath allPairsShortestPath = new AllPairsShortestPath();

        int[][] result = allPairsShortestPath.slowAllPairsShortestPath(graphMarix);
        int[][] result2 = allPairsShortestPath.fastAllPairShortestPath(graphMarix);

        assertNotNull(result);
        assertNotNull(result2);
    }
    
}
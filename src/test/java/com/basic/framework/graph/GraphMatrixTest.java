package com.basic.framework.graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphMatrixTest {
 
    @Test
    public void graphMatrixTest() {
        int size = 3;
        GraphMarix graphMarix = new GraphMarix(size);

        graphMarix.addEdge(0, 1);
        graphMarix.addEdge(0, 2);
        graphMarix.addEdge(0, 3);
        
        graphMarix.toString();

        assertTrue(graphMarix.isConnected(0, 1));
        assertTrue(graphMarix.isConnected(0, 2));
        assertTrue(graphMarix.isConnected(0, 3));
        assertFalse(graphMarix.isConnected(1, 2));
    }

}
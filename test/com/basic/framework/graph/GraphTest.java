package com.basic.framework.graph;

import static org.junit.Assert.assertEquals;

import com.basic.framework.graph.impl.GrapAdjList;
import com.basic.framework.graph.search.BreadthFirstSearch;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    private GrapAdjList graph;
    private Vertex vertex1;
    private Vertex vertex6;
    private Vertex vertex5;

    @Before
    public void setupGraph() {
        graph = new GrapAdjList();

        vertex1 = graph.addVertex();
        final Vertex vertex2 = graph.addVertex();

        graph.addEdge(vertex1, vertex2);

        final Vertex vertex3 = graph.addVertex();
        final Vertex vertex4 = graph.addVertex();
        vertex5 = graph.addVertex();
        vertex6 = graph.addVertex();

        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex2);
        graph.addEdge(vertex2, vertex5);
        graph.addEdge(vertex5, vertex4);
        graph.addEdge(vertex3, vertex5);
        graph.addEdge(vertex3, vertex6);
        graph.addEdge(vertex6, vertex6);
    }

    @Test
    public void addNewVertexTest() {
        assertEquals(2, graph.getNeighbours(vertex1).size());
        assertEquals(1, graph.getNeighbours(vertex6).size());
    }

    @Test
    public void breadthFirstSearch() {
        final BreadthFirstSearch search = new BreadthFirstSearch();

        search.search(graph, vertex1);

        assertEquals(2, vertex5.getDistance());
        assertEquals(Color.BLACK, vertex5.getStatus());

        graph.printShortestPath(vertex1, vertex5); // 1 2 5
        graph.printShortestPath(vertex1, vertex6); // No path available
    }
}

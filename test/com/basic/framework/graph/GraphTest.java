package com.basic.framework.graph;

import static org.junit.Assert.assertEquals;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.search.BreadthFirstSearch;
import com.basic.framework.graph.search.DepthFirstSearch;
import com.basic.framework.graph.structure.Color;
import com.basic.framework.graph.structure.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class GraphTest {

    private GraphList graph;
    private Vertex vertex1;
    private Vertex vertex6;
    private Vertex vertex5;

    @SuppressWarnings("unchecked")
    @Before
    public void setupGraph() {
        graph = new GraphList();

        vertex1 = graph.addVertex(1);
        final Vertex vertex2 = graph.addVertex(2);

        graph.addEdge(vertex1, vertex2);

        final Vertex vertex3 = graph.addVertex(3);
        final Vertex vertex4 = graph.addVertex(4);
        vertex5 = graph.addVertex(5);
        vertex6 = graph.addVertex(6);

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

        assertEquals(2, vertex5.getBreadth().getDistance());
        assertEquals(Color.BLACK, vertex5.getBreadth().getStatus());

        graph.printBreadthShortestPath(vertex1, vertex5); // 1 2 5
        graph.printBreadthShortestPath(vertex1, vertex6); // No path available
    }

    @SuppressWarnings("unchecked")
    @Test
    public void depthFirstSearch() {
        final DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        final GraphList graph = new GraphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);

        graph.addEdgeByKey(1, 2);
        graph.addEdgeByKey(1, 5);
        graph.addEdgeByKey(2, 3);
        graph.addEdgeByKey(2, 4);
        graph.addEdgeByKey(5, 6);
        graph.addEdgeByKey(6, 8);
        graph.addEdgeByKey(9, 6);
        graph.addEdgeByKey(7, 6);

        depthFirstSearch.search(graph);

        assertEquals(1, graph.getVertex(1).getDepth().getStartTime());
        assertEquals(2, graph.getVertex(2).getDepth().getStartTime());
        assertEquals(5, graph.getVertex(4).getDepth().getStartTime());
        assertEquals(3, graph.getVertex(3).getDepth().getStartTime());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void depthFirstSearchTopologicalSortTest() {
        final DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        final GraphList graph = new GraphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdgeByKey(1, 2);
        graph.addEdgeByKey(1, 3);
        graph.addEdgeByKey(2, 3);
        graph.addEdgeByKey(2, 5);
        graph.addEdgeByKey(4, 3);

        final Stack<Vertex> sort = depthFirstSearch.search(graph);

        assertEquals(4, sort.pop().getKey());
        assertEquals(1, sort.pop().getKey());
        assertEquals(2, sort.pop().getKey());
        assertEquals(5, sort.pop().getKey());
        assertEquals(3, sort.pop().getKey());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void depthFirstSearchReverseGraph() {
        final DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        final GraphList graph = new GraphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdgeByKey(1, 2);
        graph.addEdgeByKey(2, 3);
        graph.addEdgeByKey(2, 4);

        final GraphList graphList = depthFirstSearch.reverseEdge(graph);

        assertEquals(0, graphList.getVertex(1).getAdjacency().size());
        assertEquals(1, graphList.getVertex(2).getAdjacency().size());
        assertEquals(1, graphList.getVertex(3).getAdjacency().size());
        assertEquals(1, graphList.getVertex(4).getAdjacency().size());
    }
}

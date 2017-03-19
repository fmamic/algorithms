package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Edge;
import com.basic.framework.graph.structure.Vertex;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Finding shortest path from single source to each vertex. Returns false if there is negative cycle.
 * Time complexity: O((V-1)*E), E can be Vˇ2 so worst case is O(Vˇ3). Space complexity O(V)
 */
public class BellmanFordSingleSource {

    @SuppressWarnings("unchecked")
    public boolean searchShortestPath(final GraphList graph, final Vertex source) {
        final Map<Vertex, Integer> shortestDistanceMap = new HashMap<Vertex, Integer>();
        final int graphSize = graph.getVertexNumber();

        // O(V)
        final Collection<Vertex> vertices = graph.getVertices().values();
        for (final Vertex vertex : vertices) {
            shortestDistanceMap.put(vertex, Integer.MAX_VALUE);
        }

        shortestDistanceMap.put(source, 0);

        // O((V - 1) * E)
        for (int i = 0; i < graphSize - 1; i++) {
            final List<Edge> edges = graph.getEdges();
            for (final Edge edge : edges) {
                relax(edge, shortestDistanceMap);
            }
        }

        // O(E) - check for negative cycle
        final List<Edge> edges = graph.getEdges();
        boolean result = true;
        for (final Edge edge : edges) {
            result = relax(edge, shortestDistanceMap);
        }

        return result;
    }

    // O(1)
    private boolean relax(final Edge edge, final Map<Vertex, Integer> map) {
        final Integer distSource = map.get(edge.getSource());
        final Integer distDest = map.get(edge.getDestination());

        if (distDest > distSource + edge.getWeight()) {
            map.put(edge.getDestination(), distSource + edge.getWeight());
            edge.getDestination().setPrev(edge.getSource());
            return false;
        }

        return true;
    }

}

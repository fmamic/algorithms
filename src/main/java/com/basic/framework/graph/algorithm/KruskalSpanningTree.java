package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Edge;
import com.basic.framework.graph.structure.Vertex;
import com.basic.framework.structures.DisjointSet;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Kruskal algorithm to find minimum spanning tree in graph. O(ElogE + (E + V)alfa(V)) = O(ElogV) , space O(V + E)
 */
public class KruskalSpanningTree {

    // O(ElogE + V + E)
    @SuppressWarnings("unchecked")
    public GraphList createSpanningTreeFromGraph(final GraphList<Integer> graphList) {
        final List<Edge> edgeList = graphList.getEdges();
        Collections.sort(edgeList); // merge sort ELog(E) where E is edge of graph

        final DisjointSet disjointSet = new DisjointSet(); // O(V) space
        final GraphList spanningTree = new GraphList(); // O(E) space

        // O(V) where V is vertex of graph
        for (final Map.Entry<Integer, Vertex> entry : graphList.getVertices().entrySet()) {
            final Integer key = entry.getKey();
            disjointSet.makeSet(key); // O(1)
        }

        // O(E)
        for (final Edge edge : edgeList) {
            final Integer sourceKey = (Integer) edge.getSource().getKey();
            final Integer destinationKey = (Integer) edge.getDestination().getKey();

            if (!disjointSet.findSet(sourceKey).equals(disjointSet.findSet(destinationKey))) {
                disjointSet.union(sourceKey, destinationKey);

                spanningTree.addVertex(sourceKey);
                spanningTree.addVertex(destinationKey);
                spanningTree.addEdgeWithWeight(sourceKey, destinationKey, edge.getWeight());
            }
        }

        return spanningTree;
    }

}

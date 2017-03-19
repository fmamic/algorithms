package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.impl.GraphList;
import com.basic.framework.graph.structure.Edge;
import com.basic.framework.graph.structure.PrimVertex;
import com.basic.framework.graph.structure.Vertex;
import com.basic.framework.structures.PriorityQueue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimSpanningTree {

    @SuppressWarnings("unchecked")
    public GraphList createSpanningTreeFromGraph(final GraphList<Integer> graphList) {
        final PriorityQueue<PrimVertex> queue = new PriorityQueue<PrimVertex>();
        final Collection<Vertex> vertices = graphList.getVertices().values();
        final Map<Vertex, Edge> vertexEdgeMap = new HashMap<Vertex, Edge>();
        final GraphList<Integer> spanningTree = new GraphList<Integer>();

        // O(V)
        boolean isFirst = true;
        for (final Vertex vertex : vertices) {
            final PrimVertex primVertex = new PrimVertex();

            if (isFirst) {
                primVertex.setWeight(0);
            } else {
                primVertex.setWeight(Integer.MAX_VALUE);
            }

            primVertex.setVertex(vertex);
            queue.insert(primVertex);
            isFirst = false;
        }

        while (!queue.isEmpty()) {
            final Vertex minVertex = queue.extractMin().getVertex();
            spanningTree.addVertex((Integer) minVertex.getKey());

            final Edge resultEdge = vertexEdgeMap.get(minVertex);

            if (resultEdge != null) {
                spanningTree.addEdgeWithWeight((Integer) resultEdge.getSource().getKey(), (Integer) resultEdge.getDestination().getKey(), resultEdge.getWeight());
            }

            final List<Vertex> neighbours = minVertex.getAdjacency();
            final Map<PrimVertex, Integer> indexMap = queue.getIndexMap();
            for (final Vertex neighbour : neighbours) {
                final PrimVertex primVertex = new PrimVertex(neighbour, 0);

                if (containsVertex(indexMap, primVertex)) {
                    for (final Edge edge : graphList.getEdges()) {
                        if ((edge.getSource().equals(neighbour) || edge.getDestination().equals(neighbour))
                                && (edge.getDestination().equals(minVertex) || edge.getSource().equals(minVertex))) {
                            final PrimVertex result = getPrimVertex(indexMap, primVertex);

                            if (result.getWeight() > edge.getWeight()) {
                                final PrimVertex decreaseVertex = new PrimVertex(result.getVertex(), edge.getWeight());
                                queue.decreaseKey(primVertex, decreaseVertex);
                                vertexEdgeMap.put(result.getVertex(), edge);
                            }

                        }
                    }
                }
            }
        }

        return spanningTree;
    }

    private PrimVertex getPrimVertex(final Map<PrimVertex, Integer> map, final PrimVertex key) {
        final Collection<PrimVertex> collection = map.keySet();

        for (final PrimVertex primVertex1 : collection) {
            if (primVertex1.getVertex().getKey().equals(key.getVertex().getKey())) {
                return primVertex1;
            }
        }
        return null;
    }

    private boolean containsVertex(final Map<PrimVertex, Integer> map, final PrimVertex primVertex) {
        final Collection<PrimVertex> collection = map.keySet();

        for (final PrimVertex primVertex1 : collection) {
            if (primVertex1.getVertex().getKey().equals(primVertex.getVertex().getKey())) {
                return true;
            }
        }

        return false;
    }

}

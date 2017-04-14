package com.basic.framework.graph.structure.dijkstra;

public class DEdge {

    private DVertex source;

    private DVertex destination;

    private int weight = 0;

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public DVertex getSource() {
        return source;
    }

    public void setSource(final DVertex source) {
        this.source = source;
    }

    public DVertex getDestination() {
        return destination;
    }

    public void setDestination(final DVertex destination) {
        this.destination = destination;
    }
}

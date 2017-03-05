package com.basic.framework.graph.structure;

public class Edge {

    private Vertex source;
    private Vertex destination;

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(final Vertex destination) {
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(final Vertex source) {
        this.source = source;
    }
}

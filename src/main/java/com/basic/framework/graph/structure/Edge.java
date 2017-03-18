package com.basic.framework.graph.structure;

public class Edge implements Comparable<Edge> {

    private Integer weight;

    private Vertex source;

    private Vertex destination;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(final Integer weight) {
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(final Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(final Vertex destination) {
        this.destination = destination;
    }

    public int compareTo(final Edge edge) {
        return this.weight.compareTo(edge.getWeight());
    }
}

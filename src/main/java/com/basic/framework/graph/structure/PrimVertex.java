package com.basic.framework.graph.structure;

public class PrimVertex implements Comparable<PrimVertex> {

    public PrimVertex() {

    }

    public PrimVertex(final Vertex vertex, final Integer weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    private Vertex vertex;

    private Integer weight;

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(final Vertex vertex) {
        this.vertex = vertex;
    }

    public void setWeight(final Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public int compareTo(final PrimVertex primVertex) {
        return this.weight.compareTo(primVertex.weight);
    }
}

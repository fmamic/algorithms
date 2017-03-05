package com.basic.framework.graph.structure;

import com.basic.framework.structures.ArrayList;

public class Vertex implements Comparable {

    private Integer key;

    private Color status = Color.WHITE;

    private int distance = 0;

    private Vertex predecessor;

    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(final ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public Color getStatus() {
        return status;
    }

    public void setStatus(final Color status) {
        this.status = status;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(final Integer key) {
        this.key = key;
    }

    public int compareTo(final Object o) {
        return ((Vertex) o).getKey().compareTo(this.key);
    }
}

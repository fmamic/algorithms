package com.basic.framework.dynamic.programming.structures;

public class RodCutterResult {

    private int revenue;

    private int[] optimalCut;

    public int[] getOptimalCut() {
        return optimalCut;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void setOptimalCut(int[] optimalCut) {
        this.optimalCut = optimalCut;
    }
}
